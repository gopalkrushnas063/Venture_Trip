package com.venture.venturetrip.services.adminServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venture.venturetrip.exception.AdminException;
import com.venture.venturetrip.exception.HotelException;
import com.venture.venturetrip.exception.PackageException;
import com.venture.venturetrip.exception.RouteException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.exception.VehiclesException;
import com.venture.venturetrip.model.admin.Admin;
import com.venture.venturetrip.model.admin.AdminSignInDTO;
import com.venture.venturetrip.model.admin.CurrentAdminSession;
import com.venture.venturetrip.model.admin.Hotel;
import com.venture.venturetrip.model.admin.Package;
import com.venture.venturetrip.model.admin.Route;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.admin.Vehicles;
import com.venture.venturetrip.model.user.PackageDTO;
import com.venture.venturetrip.repository.AdminDao;
import com.venture.venturetrip.repository.AdminSessionDAO;
import com.venture.venturetrip.repository.HotelDao;
import com.venture.venturetrip.repository.PackageDao;
import com.venture.venturetrip.repository.RouteDao;
import com.venture.venturetrip.repository.TravelsDao;
import com.venture.venturetrip.repository.VehiclesDao;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminSessionDAO adminSessionDAO;

    @Autowired
    private HotelDao hotelDao;

    @Autowired
    private TravelsDao travelsdao;

    @Autowired
    private VehiclesDao vehiclesDao;
    @Autowired
    private RouteDao routeDao;

    @Autowired
    private PackageDao packageDao;


    @Override
    public Admin createAdmin(AdminSignInDTO adminsiginDto) throws AdminException {
        Optional<Admin> opt = adminDao.findByMobile(adminsiginDto.getMobile());
        if (opt.isPresent()) {
            throw new AdminException("Admin Already Registered With Mobile Number " + adminsiginDto.getMobile());
        } else {
            Admin admin = new Admin();
            admin.setAdminName(adminsiginDto.getAdminName());
            admin.setPassword(adminsiginDto.getPassword());
            admin.setMobile(adminsiginDto.getMobile());
            admin.setEmail(adminsiginDto.getEmail());
            admin.setUserType("admin");
            return adminDao.save(admin);
        }
    }

    @Override
    public Admin updateAdmin(AdminSignInDTO adminsiginDto, String key) throws AdminException {
        Optional<CurrentAdminSession> optCurrAdmin = adminSessionDAO.findByUuid(key);
        if (!optCurrAdmin.isPresent()) {
            throw new AdminException("Unauthorised Access! Enter Correct UUID");
        } else {
            Admin admin = new Admin();
            admin.setAdminName(adminsiginDto.getAdminName());
            admin.setPassword(adminsiginDto.getPassword());
            admin.setMobile(adminsiginDto.getMobile());
            admin.setEmail(adminsiginDto.getEmail());
            admin.setUserType("admin");
            return adminDao.save(admin);
        }
    }


    @Override
    public Hotel addNewHotal(Hotel hotel) throws HotelException {
        return hotelDao.save(hotel);
    }


    @Override
    public Hotel updateHotalDetails(Hotel hotel) throws HotelException {
        Optional<Hotel> opt = hotelDao.findById(hotel.getHotelID());
        if (opt.isPresent()) {
            hotelDao.save(hotel);
            return hotel;
        } else {
            throw new HotelException("Hotel not found with HotelID : " + hotel.getHotelID());
        }
    }


    @Override
    public Hotel RemoveHotalDetails(Integer hotelID) throws HotelException {
        Optional<Hotel> opt = hotelDao.findById(hotelID);
        if (opt.isPresent()) {
            hotelDao.deleteById(hotelID);
            return opt.get();
        } else {
            throw new HotelException("Hotel not found with HotelID : " + hotelID);
        }
    }


    @Override
    public List<Hotel> getAllHotelDetails() throws HotelException {
        List<Hotel> hotels = hotelDao.findAll();
        if (hotels.isEmpty()) {
            throw new HotelException("No any Hotel found in Database..");
        } else {
            return hotels;
        }
    }


    @Override
    public Travels addNewTravelsDetails(Travels travels) throws TravelsException {
        return travelsdao.save(travels);
    }

    @Override
    public Travels updateTravelDetails(Travels travels) throws TravelsException {
        Optional<Travels> opt = travelsdao.findById(travels.getTravelsID());
        if (opt.isPresent()) {
            Travels existingTraveler = opt.get();
            travels.setRoutes(existingTraveler.getRoutes());
            return travelsdao.save(travels);
        } else {
            throw new TravelsException("Travelers does not exist with travelers ID : " + travels.getTravelsID());
        }
    }

    @Override
    public Travels removeTravel(Integer travelersID) throws TravelsException {
        Optional<Travels> opt = travelsdao.findById(travelersID);
        if (opt.isPresent()) {
            travelsdao.deleteById(travelersID);
            return opt.get();
        } else {
            throw new TravelsException("Travellers does not exist with Traveler's ID : " + travelersID);
        }
    }


    @Override
    public Vehicles addNewVehiclesDetails(Vehicles vehicles) throws RouteException {
        Optional<Route> opt = routeDao.findById(vehicles.getRouteID());
        if (opt.isPresent()) {
            opt.get().setVehicles(vehicles);
            return opt.get().getVehicles();
        } else {
            throw new RouteException("Route not found with route ID : " + vehicles.getRouteID());
        }
    }

    @Override
    public Vehicles updateVehicleDetails(Vehicles vehicles) throws VehiclesException, RouteException {
        Optional<Vehicles> opt = vehiclesDao.findById(vehicles.getVehicleNumber());
        if (opt.isPresent()) {
            Optional<Route> route = routeDao.findById(vehicles.getRouteID());
            if (route.isPresent()) {
                //route.get().setVehicles(vehicles);
                return vehiclesDao.save(vehicles);
            } else {
                throw new RouteException("Route does not exist with the given route ID : " + vehicles.getRouteID());
            }
        } else {
            throw new VehiclesException("Vehicle does not exist with the vehicle number : " + vehicles.getVehicleNumber());
        }

    }

    @Override
    public Package addNewPackageDetails(Package package1, Integer travelsID, Integer routeID, Integer hotelID) throws PackageException {
        Optional<Travels> opt = travelsdao.findById(travelsID);
        if (opt.isPresent()) {
            Optional<Route> opt2 = routeDao.findById(routeID);
            if (opt2.isPresent()) {
                Optional<Hotel> opt3 = hotelDao.findById(hotelID);
                if (opt3.isPresent()) {
                    package1.setTravels(opt.get());
                    package1.setRoute(opt2.get());
                    package1.setHotel(opt3.get());
                    return packageDao.save(package1);
                } else {
                    throw new PackageException("Hotel does exist with Hotel ID : " + hotelID);
                }
            } else {
                throw new PackageException("Route does exist with Route ID : " + routeID);
            }
        } else {
            throw new PackageException("Travels does exist with Travels ID : " + travelsID);
        }
    }

    @Override
    public List<PackageDTO> getAllPackageDetails(String from, String to) throws PackageException {
        List<Package> packages = packageDao.findAll();
        List<PackageDTO> packageDTOs = new ArrayList<>();
        for (Package pac : packages) {
            if (pac.getRoute().getRouteFrom().equalsIgnoreCase(from) && pac.getRoute().getRouteTo().equalsIgnoreCase(to)) {
                PackageDTO p = new PackageDTO();
                p.setPackageID(pac.getPackageID());
                p.setPackageName(pac.getPackageName());
                p.setHotelName(pac.getHotel().getHotelName());
                p.setRouteForm(pac.getRoute().getRouteFrom());
                p.setRouteTo(pac.getRoute().getRouteTo());
                p.setTravellersName(pac.getTravels().getTravelsName());
                p.setVehicleType("Bus");
                p.setFare(pac.getPackageCost());
                packageDTOs.add(p);
            }
        }
        if (packageDTOs.isEmpty()) {
            throw new PackageException("No any package found");
        } else {
            return packageDTOs;
        }

    }

    @Override
    public Package updatePackageDetails(Package pack) throws PackageException {
        Optional<Package> opt = packageDao.findById(pack.getPackageID());
        if (opt.isPresent()) {
            return packageDao.save(pack);
        } else {
            throw new PackageException("Package does exist with Package ID : " + pack.getPackageID());
        }
    }

    @Override
    public Package removePackageDetailsByID(Integer packID) throws PackageException {
        Optional<Package> opt = packageDao.findById(packID);
        if (opt.isPresent()) {
            packageDao.deleteById(packID);
            return opt.get();
        } else {
            throw new PackageException("Package does not exist with package ID : " + packID);
        }
    }
}
