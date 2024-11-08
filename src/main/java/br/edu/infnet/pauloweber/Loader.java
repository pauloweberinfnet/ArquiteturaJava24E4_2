package br.edu.infnet.pauloweber;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.pauloweber.model.domain.Combustion;
import br.edu.infnet.pauloweber.model.domain.Driver;
import br.edu.infnet.pauloweber.model.domain.Eletric;
import br.edu.infnet.pauloweber.model.domain.Trip;
import br.edu.infnet.pauloweber.model.service.DriverService;
import br.edu.infnet.pauloweber.model.service.VehicleService;

@Component
public class Loader implements ApplicationRunner {

  @Autowired
  private DriverService driverService;
  @Autowired
  private VehicleService vehicleService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("🖧 Iniciando o carregamento dos dados... 🖧");
    System.out.println("🛈 Carregando os dados dos motoristas... 👩👨");

    BufferedReader driversData = readFile("files/drivers.csv");

    String line = driversData.readLine();

    Driver driver = null;
    while (line != null) {
      if (line.contains("name")) {
        line = driversData.readLine();
        continue;
      }
      String[] fields = line.split(";");
      driver = new Driver(fields[1], fields[0]);

      // Incluir o motorista no banco de dados
      driver = driverService.add(driver);

      System.out.println(driver.toString());

      line = driversData.readLine();
    }

    driversData.close();
    System.out.println("✅ Motoristas carregados com sucesso!");

    System.out.println("🛈 Carregando os dados dos veículos elétricos... 🚙🔌");

    BufferedReader eletricData = readFile("files/eletric_vehicles.csv");
    String lineEletric = eletricData.readLine();

    Eletric eletric = null;
    while (lineEletric != null) {
      if (lineEletric.contains("licensePlate")) {
        lineEletric = eletricData.readLine();
        continue;
      }
      String[] fields = lineEletric.split(";");
      eletric = new Eletric();
      eletric.setLicensePlate(fields[0]);
      eletric.setArchived(Boolean.parseBoolean(fields[1]));
      eletric.setOdometer(Float.parseFloat(fields[2]));
      eletric.setBrand(fields[3]);
      eletric.setModel(fields[4]);
      eletric.setModelYear(Integer.parseInt(fields[5]));
      eletric.setBatteryNominalCapacity(fields[6]);
      eletric.setBatteryCurrentCapacity(Float.parseFloat(fields[7]));
      eletric.setBatteryHealth(Float.parseFloat(fields[8]));

      System.out.println(eletric.toString());

      vehicleService.add(eletric);

      System.out.println("Veículo elétrico: " + eletric.getLicensePlate() + " - " + eletric.getBrand() + " - " + eletric.getModel());

      lineEletric = eletricData.readLine();
    }
    eletricData.close();
    System.out.println("✅ Veículos elétricos carregados com sucesso!");

    System.out.println("🛈 Carregando os dados dos veículos a combustão... 🚙⛽");

    BufferedReader combustionData = readFile("files/combustion_vehicles.csv");
    String lineCombustion = combustionData.readLine();

    Combustion combustion = null;
    while (lineCombustion != null) {
      if (lineCombustion.contains("licensePlate")) {
        lineCombustion = combustionData.readLine();
        continue;
      }
      String[] fields = lineCombustion.split(";");
      combustion = new Combustion();
      combustion.setLicensePlate(fields[0]);
      combustion.setArchived(Boolean.parseBoolean(fields[1]));
      combustion.setOdometer(Float.parseFloat(fields[2]));
      combustion.setBrand(fields[3]);
      combustion.setModel(fields[4]);
      combustion.setModelYear(Integer.parseInt(fields[5]));
      combustion.setFuelType(fields[6]);
      combustion.setFuelTankCapacity(Float.parseFloat(fields[7]));
      combustion.setFuelLevel(Float.parseFloat(fields[8]));

      System.out.println("Veículo a combustão: " + combustion.getLicensePlate() + " - " + combustion.getBrand() + " - " + combustion.getModel());

      lineCombustion = combustionData.readLine();
    }
    combustionData.close();
    System.out.println("✅ Veículos a combustão carregados com sucesso!");

    System.out.println("🛈 Carregando dados das viagens... 🌎");

    BufferedReader tripsData = readFile("files/trips.csv");
    String lineTrip = tripsData.readLine();

    Trip trip = null;
    while (lineTrip != null) {
      if (lineTrip.contains("startingOdometer")) {
        lineTrip = tripsData.readLine();
        continue;
      }
      String[] fields = lineTrip.split(";");
      trip = new Trip();

      trip.setStartingOdometer(Float.valueOf(fields[0]));
      trip.setEndingOdometer(Float.valueOf(fields[1]));
      trip.setDistance(Float.valueOf(fields[0]), Float.valueOf(fields[1]));
      trip.setStartTime(LocalDateTime.parse(fields[2]));
      trip.setEndTime(LocalDateTime.parse(fields[3]));
      trip.setTripDuration(trip.getStartTime(), trip.getEndTime());
      trip.setAverageSpeed(trip.getDistance(), trip.getTripDuration());
      trip.setStartingFuelLevel(Float.valueOf(fields[4]));
      trip.setEndingFuelLevel(Float.valueOf(fields[5]));
      trip.setFuelConsumption(trip.getStartingFuelLevel(), trip.getEndingFuelLevel());
      trip.setAverageConsumption(trip.getDistance(), trip.getFuelConsumption());
      // TODO: Setar o veículo e o motorista
      System.out.println(trip.toString());

      lineTrip = tripsData.readLine();
    }

    // Service Tests
    System.out.println("Testando serviços...");
    System.out.println("🔎 findByNameContaining - João: " + driverService.getByNameContaining("João"));
    System.out.println("🔎 findByLicenseId - 987654321: " + driverService.getByLicenseId("987654321"));
  }




 public BufferedReader readFile(String fileName) {
    FileReader file = null;
    BufferedReader reader = null;
    try {
      file = new FileReader(fileName);
      reader = new BufferedReader(file);
    } catch (FileNotFoundException e) {
      System.out.println("Não foi possível encontrar o arquivo: " + fileName);
    }
    return reader;
  }
}