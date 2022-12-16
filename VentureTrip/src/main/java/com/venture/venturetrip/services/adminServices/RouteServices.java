package com.venture.venturetrip.services.adminServices;

import com.venture.venturetrip.exception.RouteException;
import com.venture.venturetrip.exception.VehiclesException;
import com.venture.venturetrip.model.admin.Route;

public interface RouteServices {
    public Route addRoute(Route route) throws RouteException;
    public Route updateRoute(Route route) throws RouteException, VehiclesException;
    public Route deleteRoute(Integer routeID) throws RouteException;

}
