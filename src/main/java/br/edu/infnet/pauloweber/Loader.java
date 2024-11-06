package br.edu.infnet.pauloweber;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.pauloweber.model.domain.Combustion;
import br.edu.infnet.pauloweber.model.domain.Driver;
import br.edu.infnet.pauloweber.model.domain.Eletric;

@Component
public class Loader implements ApplicationRunner {

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("🖧 Iniciando o carregamento dos dados... 🖧");
    System.out.println("👩 Carregando os dados dos motoristas... 👨");
    FileReader driversFile = new FileReader("files/drivers.csv");
		BufferedReader driversData = new BufferedReader(driversFile);

    String line = driversData.readLine();

    Driver driver = null;
    while (line != null) {
      if (line.contains("name")) {
        line = driversData.readLine();
        continue;
      }
      String[] fields = line.split(";");
      driver = new Driver();
      driver.setName(fields[0]);
      driver.setLicenseId(fields[1]);
      System.out.println("Motorista: " + driver.getName() + " - " + driver.getLicenseId());

      // TODO: persistir o motorista no banco de dados
      // driver = driverRepository.save(driver);
      line = driversData.readLine();
    }

    driversData.close();
    System.out.println("✅ Motoristas carregados com sucesso!");

    System.out.println("🚙 Carregando os dados dos veículos elétricos... 🔌");

    FileReader eletricFile = new FileReader("files/eletric_vehicles.csv");
    BufferedReader eletricData = new BufferedReader(eletricFile);
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
      eletric.setYear(Integer.parseInt(fields[5]));
      eletric.setBatteryNominalCapacity(fields[6]);
      eletric.setBatteryCurrentCapacity(Float.parseFloat(fields[7]));
      eletric.setBatteryHealth(Float.parseFloat(fields[8]));

      System.out.println("Veículo elétrico: " + eletric.getLicensePlate() + " - " + eletric.getBrand() + " - " + eletric.getModel());

      lineEletric = eletricData.readLine();
    }
    eletricData.close();
    System.out.println("✅ Veículos elétricos carregados com sucesso!");

    System.out.println("🚙 Carregando os dados dos veículos a combustão... ⛽");

    FileReader combustionFile = new FileReader("files/combustion_vehicles.csv");
    BufferedReader combustionData = new BufferedReader(combustionFile);
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
      combustion.setYear(Integer.parseInt(fields[5]));
      combustion.setFuelType(fields[6]);
      combustion.setFuelTankCapacity(Float.parseFloat(fields[7]));
      combustion.setFuelLevel(Float.parseFloat(fields[8]));

      System.out.println("Veículo a combustão: " + combustion.getLicensePlate() + " - " + combustion.getBrand() + " - " + combustion.getModel());

      lineCombustion = combustionData.readLine();
    }
    combustionData.close();
    System.out.println("✅ Veículos a combustão carregados com sucesso!");

  }

}
