package com.mbtec.staffnoc.controller;

import com.jfoenix.controls.JFXButton;
import com.mbtec.staffnoc.dao.ActivityDAO;
import com.mbtec.staffnoc.domain.Activity;
import com.mbtec.staffnoc.domain.Bts;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable {
    @FXML
    private JFXButton btnDame;

    @FXML
    private JFXButton btnUndone;

    @FXML
    private TableColumn<Activity, String> colunaActividadeAct;

    @FXML
    private TableColumn<Activity, String> colunaBTSAct;

    @FXML
    private TableColumn<Activity, Integer> colunaCodigoAct;

    @FXML
    private TableColumn<Activity, String> colunaDateDoneAct;

    @FXML
    private TableColumn<Activity, String> colunaDoneAct;

    @FXML
    private TableColumn<Activity, String> colunacurrentymonth;

    @FXML
    private TableView<Activity> tableviewNocstaff;

    @FXML
    private Text lbCollab;

    @FXML
    private Text lbPhoneStaffAct;

    @FXML
    private Text lbPhoneCollab;

    @FXML
    private Text lbStaffAct;

    private final ActivityDAO activityDAO = new ActivityDAO();
    private Bts bts = new Bts();

    private List<Activity> activityList;
    private ObservableList<Activity> activityObservableList;
    private FilteredList<Activity> activityFilteredList;
    private ObservableList<Bts> btsObservableList;
    private FilteredList<Bts> btsFilteredList;


    @FXML
    void btnDone(ActionEvent event) {

    }

    @FXML
    void btnUndone(ActionEvent event) {

    }

    @FXML
    void menuItemClose(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTableView();
        loadList();
        tableViewListener();
    }

    private void loadList() {
        activityList = activityDAO.list();
        System.out.println(activityList);
        activityObservableList = FXCollections.observableArrayList(activityList);
        activityFilteredList = new FilteredList<>(activityObservableList, a -> true);
        tableviewNocstaff.setItems(activityFilteredList);
    }

    public void loadTableView() {
        colunaCodigoAct.setCellValueFactory(cell ->
                new ReadOnlyObjectWrapper<>(
                        tableviewNocstaff.getItems().indexOf(cell.getValue()) + 1));
        colunaCodigoAct.setSortable(false);

        colunaActividadeAct.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getActivity()));

        colunaBTSAct.setCellValueFactory(cellData -> {
            if (cellData.getValue().getBts() != null) {
                return new SimpleStringProperty(
                        cellData.getValue().getBts().getSite_code()
                );
            } else {
                return new SimpleStringProperty("Without BTS assigned");
            }
        });

        colunaDateDoneAct.setCellValueFactory(cellData -> {
            String date = cellData.getValue().getDate_done();
            if (date != null && !date.isBlank()) {
                return new SimpleStringProperty(date);
            }
            return new SimpleStringProperty("Pending...");
        });

        colunaDoneAct.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().isDone() ? "Done" : "Pending..."));

        colunacurrentymonth.setCellValueFactory(cell ->
                new SimpleStringProperty(cell.getValue().getCurrenty_month()));
    }

    public void tableViewListener(){
        tableviewNocstaff.getSelectionModel().selectedItemProperty().addListener((obs, old, selected)->{
            if (selected != null){
                lbStaffAct.setText(selected.getBts().getTechnical_staff().getName());
                lbPhoneStaffAct.setText(selected.getBts().getTechnical_staff().getPhonenumber());
                lbCollab.setText(selected.getBts().getCollab().getName());
                lbPhoneCollab.setText(selected.getBts().getCollab().getPhonenumber());
            }
        });
    }
}
