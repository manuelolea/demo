module sim.bdeb.qc.ca.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens sim.bdeb.qc.ca.demo to javafx.fxml;
    exports sim.bdeb.qc.ca.demo;
}