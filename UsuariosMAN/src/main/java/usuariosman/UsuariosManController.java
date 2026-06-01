package usuariosman;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import usuariosman.model.SQLAccessUsuario;
import usuariosman.model.Usuario;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class UsuariosManController {


    private boolean isNewPerson =  false;
    private Usuario us;
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();


    //Panel Principal
    @FXML
    private AnchorPane mainView;
    @FXML
    private AnchorPane formView;
    @FXML
    private AnchorPane delView;

    @FXML
    private AnchorPane listadoView;

    @FXML
    public void initialize() {
        // Inicar el programa con el panel 0, el main
        selectPanelVisible(0);

        //
        this.clearFieldTexts();
        //Desabilitamos los botones
        this.guardarFormButton.setDisable(true);



        this.nombreTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {

            this.nombreTextF.getStyleClass().add("my-validated-text");
            this.isNombreValido = true;
            this.guardarFormButton.setDisable(!this.isValidoFormulario());
        });


        this.apellidosTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {

            this.apellidosTextF.getStyleClass().add("my-validated-text");
            this.isApellidosValido = true;
            this.guardarFormButton.setDisable(!this.isValidoFormulario());
        });


        this.dniTextF.focusedProperty().addListener((observable, oldValue, newValue) -> {

            if (!newValue) {
                if (!this.validateDni(dniTextF.getText())) {

                    this.dniTextF.setText("");
                    this.dniTextF.getStyleClass().remove("my-validated-text");
                    this.dniTextF.getStyleClass().add("my-error-text");

                    this.dniTextF.setPromptText("Debe ingresar un dni correcto");
                    this.isDniValido = false;
                }
                else  {
                    this.dniTextF.getStyleClass().add("my-validated-text");
                    this.dniTextF.getStyleClass().remove("my-error-text");

                    this.isDniValido = true;
                }
                this.guardarFormButton.setDisable(!this.isValidoFormulario());
            }
        });


        this.fechaNacimientoTextf.focusedProperty().addListener((observable, oldValue, newValue) -> {

            //Si queremos que tenga como minimo un valor

            if (newValue != null) {
                this.fechaNacimientoTextf.getStyleClass().add("my-validated-text");
                this.isFechaNacimientoValido = true;
            }else {
                this.fechaNacimientoTextf.getStyleClass().add("my-error-text");
                this.isFechaNacimientoValido = false;
            }
            this.guardarFormButton.setDisable(!this.isValidoFormulario());
        });

        this.usuariosListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            this.us = newValue;

            if(newValue != null) {
                this.eliminarListViewButton.setDisable(false);
            }else  {
                this.eliminarListViewButton.setDisable(true);
            }
        });

        this.listadoListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            this.us = newValue;
            if(newValue != null) {
                this.eliminarListViewButton.setDisable(false);
            }else   {
                this.eliminarListViewButton.setDisable(true);
            }
        });

        this.buscarNombreTF.textProperty().addListener((observable, oldValue, newValue) -> {

            this.usuarios.clear();

            if(newValue.isEmpty()) {
                this.usuarios.setAll(SQLAccessUsuario.getAllUsuarios());
            }else  {

                this.usuarios.setAll(SQLAccessUsuario.getUsuariosByNameContains(newValue));
            }

            this.listadoListView.setItems(this.usuarios);

        });

    }



        //Panel Principal Salir button
    @FXML
    public void onSalirButtonClick(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public Label labelFormTitle;

        //Panel Principal Insertar button

    @FXML
    public void onInsertButtonClick(ActionEvent actionEvent) {

        this.isNewPerson = true;
        this.configureFormView();
        this.selectPanelVisible(1);
    }

    @FXML
    public void onEliminarButton(ActionEvent actionEvent) {
        this.loadPersonInListView();
        this.selectPanelVisible(2);
    }

    @FXML
    public void onListadoButton (ActionEvent actionEvent) {
        this.loadPersonInListView();
        this.selectPanelVisible(3);
    }




    //Panel de Formulario


        //Campos del Formulario

    @FXML
    private TextField nombreTextF;
    @FXML
    private TextField apellidosTextF;
    @FXML
    private TextField dniTextF;
    @FXML
    private DatePicker fechaNacimientoTextf;
    @FXML
    private Button guardarFormButton;

    // Variables para los botones Enable o no
    private boolean isDniValido = false, isNombreValido = false, isApellidosValido = false,
            isFechaNacimientoValido = false;


    //Metodo para que si todo el formulario este correcto se ponga enable el boton de guardar
    // Metodos validaciones y auxiliares
    public boolean isValidoFormulario(){
        return (isDniValido && isNombreValido && isApellidosValido
                 && isFechaNacimientoValido);
    }


    @FXML
    public void onGuardarFormClick(ActionEvent actionEvent) {

        // Guardamos Formulario E insertamos Datos en la base de datos

        if (isNewPerson) {

            this.us = Usuario.builder()
                    .nombre(nombreTextF.getText())
                    .apellido(apellidosTextF.getText())
                    .dni(dniTextF.getText())
                    .fecha_nacimiento(fechaNacimientoTextf.getValue())
                    .build();

            SQLAccessUsuario.createUsuario(this.us);

        }else {
            this.us.setNombre(nombreTextF.getText());
            this.us.setApellido(apellidosTextF.getText());
            this.us.setDni(dniTextF.getText());
            this.us.setFecha_nacimiento(fechaNacimientoTextf.getValue());

            SQLAccessUsuario.updateUsuario(this.us);
        }
        loadPersonInListView();
        clearFieldTexts();
        selectPanelVisible(0);

    }

    @FXML
    public void onCancelFormClick(ActionEvent actionEvent) {
        this.selectPanelVisible(0);
        this.clearFieldTexts();
    }


    //Validaciones

    private boolean validateDni(String dni){
        return dni.matches("[0-9]{7,8}[A-Z a-z]");
    }



    //Panel de Eliminar

    @FXML
    private Button cancelListViewButton;

    @FXML
    private Button eliminarListViewButton;

    @FXML
    private ListView<Usuario> usuariosListView;



    @FXML
    private void onCancelListViewButton (ActionEvent actionEvent) {
        selectPanelVisible(0);
    }


    @FXML
    private void onEliminarListViewButton (ActionEvent actionEvent) {

        if(this.us != null){

            SQLAccessUsuario.deleteUsuario(this.us.getId_usuario());

            this.loadPersonInListView();
        }else {
            System.out.println("us es null, no hay usuario seleccionado");
        }
    }

    public void loadPersonInListView (){
        this.usuarios.clear();

        List<Usuario> misUsuarios = SQLAccessUsuario.getAllUsuarios();

        this.usuarios.addAll(misUsuarios);

        this.usuariosListView.setItems(this.usuarios);
        this.listadoListView.setItems(this.usuarios);
    }



    //Panel Buscar lista


    @FXML
    private ListView<Usuario> listadoListView;

    @FXML
    private TextField buscarNombreTF;

    @FXML
    public void onCancelListadoListViewButton (){

        selectPanelVisible(0);

    }


    // Editar Usuario

    public void onEditarListViewButton(){

        if(this.us != null){
            // Cargar datos en el formulario y configurar que estamos en editar
            this.isNewPerson = false;
            this.configureFormView();
            this.selectPanelVisible(1);

        }

    }


    //Limpiar Campos
    private void clearFieldTexts (){
        nombreTextF.clear();
        apellidosTextF.clear();
        dniTextF.clear();
        fechaNacimientoTextf.setValue(null);

        this.nombreTextF.setPromptText("Pedro");
        this.apellidosTextF.setPromptText("Picapiedra Marmol");
        this.dniTextF.setPromptText("12345678Z");

        this.nombreTextF.getStyleClass().remove("my-validated-text");
        this.nombreTextF.getStyleClass().remove("my-error-text");

        this.apellidosTextF.getStyleClass().remove("my-validated-text");
        this.apellidosTextF.getStyleClass().remove("my-error-text");

        this.dniTextF.getStyleClass().remove("my-validated-text");
        this.dniTextF.getStyleClass().remove("my-error-text");

        this.fechaNacimientoTextf.getStyleClass().remove("my-validated-text");
        this.fechaNacimientoTextf.getStyleClass().remove("my-error-text");
    }

    //Selccion de paneles
    private void selectPanelVisible(int panel){
        switch (panel){
            case 0: //panel principal
                this.mainView.setVisible(true);
                this.formView.setVisible(false);
                this.delView.setVisible(false);
                this.listadoView.setVisible(false);
                break;

            case 1: //panel formulario
                this.mainView.setVisible(false);
                this.formView.setVisible(true);
                this.delView.setVisible(false);
                this.listadoView.setVisible(false);
                break;

            case 2: //panel Eliminar
                this.mainView.setVisible(false);
                this.formView.setVisible(false);
                this.delView.setVisible(true);
                this.listadoView.setVisible(false);
                break;

            case 3: //panel Listado
                this.mainView.setVisible(false);
                this.formView.setVisible(false);
                this.delView.setVisible(false);
                this.listadoView.setVisible(true);
                break;

            default:
                this.mainView.setVisible(true);
//                this.listView.setVisible(false);
                this.formView.setVisible(false);

        }
    }


    private void configureFormView() {
        if (isNewPerson) {
            this.labelFormTitle.setText("Insertar nueva Persona");
        } else {
            this.labelFormTitle.setText("Editar nueva Persona");

            if(us != null){
                this.nombreTextF.setText(us.getNombre());
                this.apellidosTextF.setText(us.getApellido());
                this.dniTextF.setText(us.getDni());
                this.fechaNacimientoTextf.setValue(us.getFecha_nacimiento());
            }
        }

    }


}
