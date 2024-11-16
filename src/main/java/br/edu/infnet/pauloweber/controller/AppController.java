package br.edu.infnet.pauloweber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.pauloweber.model.service.DriverService;
import br.edu.infnet.pauloweber.model.service.TripService;
import br.edu.infnet.pauloweber.model.service.VehicleService;
import br.edu.infnet.pauloweber.model.service.CombustionService;
import br.edu.infnet.pauloweber.model.service.EletricService;

@Controller
public class AppController {

  @Autowired
  private DriverService driverService;
  @Autowired
  private VehicleService vehicleService;
  @Autowired
  private CombustionService combustionService;
  @Autowired
  private EletricService eletricService;
  @Autowired
  private TripService tripService;

  @GetMapping(value = "/")
  public String homeScreen(Model model) {
    model.addAttribute("driverCount", driverService.count());
    model.addAttribute("vehicleCount", vehicleService.count());
    model.addAttribute("tripCount", tripService.count());
    return "home";

  }

  @GetMapping(value = "/drivers")
  public String driver(Model model) {
    model.addAttribute("drivers", driverService.getAll());
    return "drivers";
  }

  @GetMapping(value = "/vehicles")
  public String vehicle(Model model) {
    model.addAttribute("vehicles", vehicleService.getAll());
    return "vehicles";
  }

  @GetMapping(value = "/vehicles/combustion")
  public String combustion(Model model) {
    model.addAttribute("vehicles", combustionService.getAll());
    return "vehicles/combustion";
  }
  @GetMapping(value = "/vehicles/eletric")
  public String eletric(Model model) {
    model.addAttribute("vehicles", eletricService.getAll());
    return "vehicles/eletric";
  }

  @GetMapping(value = "/trips")
  public String trip(Model model) {
    model.addAttribute("trips", tripService.getAll());
    return "trips";
  }


}
