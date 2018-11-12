package ua.nure.pertseva.airline;

import org.apache.catalina.ant.ValidatorTask;
import org.junit.runners.Suite.SuiteClasses;

import ua.nure.pertseva.airline.commands.AddCrewCommandTest;
import ua.nure.pertseva.airline.entity.CrewTest;
import ua.nure.pertseva.airline.entity.EmployeeTest;
import ua.nure.pertseva.airline.entity.FlightTest;
import ua.nure.pertseva.airline.entity.RequestTest;
import ua.nure.pertseva.airline.entity.UserTest;
import ua.nure.pertseva.airline.utils.HashTest;

@SuiteClasses({ AddCrewCommandTest.class, CrewTest.class, EmployeeTest.class, FlightTest.class, RequestTest.class,
		UserTest.class, HashTest.class, ValidatorTask.class })
public class MainTest {

}
