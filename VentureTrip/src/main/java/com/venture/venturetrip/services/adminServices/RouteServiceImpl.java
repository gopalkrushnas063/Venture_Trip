package com.venture.venturetrip.services.adminServices;

import com.venture.venturetrip.exception.RouteException;
import com.venture.venturetrip.exception.TravelsException;
import com.venture.venturetrip.exception.VehiclesException;
import com.venture.venturetrip.model.admin.Route;
import com.venture.venturetrip.model.admin.Travels;
import com.venture.venturetrip.model.admin.Vehicles;
import com.venture.venturetrip.repository.RouteDao;
import com.venture.venturetrip.repository.TravelsDao;
import com.venture.venturetrip.repository.VehiclesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteServices {

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private TravelsDao travelsDao;

    @Autowired
    private VehiclesDao vehiclesDao;


    @Override
    public Route addRoute(Route route) throws VehiclesException {

        Optional<Travels> opt = travelsDao.findById(route.getTravelsID());
        if (opt.isPresent()) {
            Travels existingTravel = opt.get();
            //existingTravel.getRoutes().add(route);
            return routeDao.save(route);
        } else {
            throw new VehiclesException("Vehicle does not exist with vehicle number : " + route.getTravelsID());
        }


    }

    @Override
    public Route updateRoute(Route route) throws RouteException, VehiclesException {
        Optional<Route> opt = routeDao.findById(route.getRouteID());
        if (opt.isPresent()) {
            Optional<Travels> opt1 = travelsDao.findById(route.getTravelsID());

            if (opt1.isPresent()) {
                List<Route> routes = opt1.get().getRoutes();
                for (Route route1 : routes) {
                    if (route1.getRouteID() == route.getRouteID()) {
                        route1.setRouteFrom(route.getRouteFrom());
                        route1.setRouteTo(route.getRouteTo());
                        route1.setDepartureTime(route.getDepartureTime());
                        route1.setArrivalTime(route.getArrivalTime());
                        route1.setDoj(route.getDoj());
                        route1.setPickupPoint(route.getPickupPoint());
                        route1.setFare(route.getFare());
                    }
                }
                return routeDao.save(route);
            } else {
                throw new TravelsException("Traveller does not exist with the given travelID : " + route.getTravelsID());
            }
        } else {
            throw new RouteException("Route does not exist with routeID : " + route.getRouteID());
        }
    }

    @Override
    public Route deleteRoute(Integer routeID) throws RouteException {
        Optional<Route> opt = routeDao.findById(routeID);
        if (opt.isPresent()) {
            routeDao.deleteById(routeID);
            return opt.get();
        } else {
            throw new RouteException("Route does not exist with route ID : " + routeID);
        }

    }
}
