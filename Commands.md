### Compiling Classes Commands
javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar edu\ucalgary\oop\DisasterVictim.java edu\ucalgary\oop\FamilyRelation.java edu\ucalgary\oop\Inquirer.java edu\ucalgary\oop\Location.java edu\ucalgary\oop\MedicalRecord.java edu\ucalgary\oop\ReliefService.java edu\ucalgary\oop\Supply.java

### Compiling Test Classes Commands
javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar edu\ucalgary\oop\DisasterVictimTest.java edu\ucalgary\oop\FamilyRelationTest.java edu\ucalgary\oop\InquirerTest.java edu\ucalgary\oop\LocationTest.java edu\ucalgary\oop\MedicalRecordTest.java edu\ucalgary\oop\ReliefServiceTest.java edu\ucalgary\oop\SupplyTest.java

### Running Commands
java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.ucalgary.oop.DisasterVictimTest edu.ucalgary.oop.FamilyRelationTest edu.ucalgary.oop.InquirerTest edu.ucalgary.oop.LocationTest edu.ucalgary.oop.MedicalRecordTest edu.ucalgary.oop.ReliefServiceTest edu.ucalgary.oop.SupplyTest