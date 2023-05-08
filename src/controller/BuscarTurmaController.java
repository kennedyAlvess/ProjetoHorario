package controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.dao.TurmasDAO;
import model.database.Database;
import model.database.DatabasePostgreSQL;
import model.entidades.Turma;

public class BuscarTurmaController implements Initializable {

    @FXML
    private Label labe4M1;
    @FXML
    private Label labe4M2;
    @FXML
    private Label labe4M3;
    @FXML
    private Label labe4M4;
    @FXML
    private Label labe4M5;
    @FXML
    private Label labe4M6;
    @FXML
    private Label labe4N1;
    @FXML
    private Label labe4N2;
    @FXML
    private Label labe4N3;
    @FXML
    private Label labe4N4;
    @FXML
    private Label labe4T1;
    @FXML
    private Label labe4T2;
    @FXML
    private Label labe4T3;
    @FXML
    private Label labe4T4;
    @FXML
    private Label labe4T5;
    @FXML
    private Label labe4T6;
    @FXML
    private Label labe5N1;
    @FXML
    private Label labe5N2;
    @FXML
    private Label labe5N3;
    @FXML
    private Label labe5N4;
    @FXML
    private Label label2M1;
    @FXML
    private Label label2M2;
    @FXML
    private Label label2M3;
    @FXML
    private Label label2M4;
    @FXML
    private Label label2M5;
    @FXML
    private Label label2M6;
    @FXML
    private Label label2N1;
    @FXML
    private Label label2N2;
    @FXML
    private Label label2N3;
    @FXML
    private Label label2N4;
    @FXML
    private Label label2T1;
    @FXML
    private Label label2T2;
    @FXML
    private Label label2T3;
    @FXML
    private Label label2T4;
    @FXML
    private Label label2T5;
    @FXML
    private Label label2T6;
    @FXML
    private Label label3M1;
    @FXML
    private Label label3M2;
    @FXML
    private Label label3M3;
    @FXML
    private Label label3M4;
    @FXML
    private Label label3M5;
    @FXML
    private Label label3M6;
    @FXML
    private Label label3N1;
    @FXML
    private Label label3N2;
    @FXML
    private Label label3N3;
    @FXML
    private Label label3N4;
    @FXML
    private Label label3T1;
    @FXML
    private Label label3T2;
    @FXML
    private Label label3T3;
    @FXML
    private Label label3T4;
    @FXML
    private Label label3T5;
    @FXML
    private Label label3T6;
    @FXML
    private Label label5M1;
    @FXML
    private Label label5M2;
    @FXML
    private Label label5M3;
    @FXML
    private Label label5M4;
    @FXML
    private Label label5M5;
    @FXML
    private Label label5M6;
    @FXML
    private Label label5T1;
    @FXML
    private Label label5T2;
    @FXML
    private Label label5T3;
    @FXML
    private Label label5T4;
    @FXML
    private Label label5T5;
    @FXML
    private Label label5T6;
    @FXML
    private Label label6M1;
    @FXML
    private Label label6M2;
    @FXML
    private Label label6M3;
    @FXML
    private Label label6M4;
    @FXML
    private Label label6M5;
    @FXML
    private Label label6M6;
    @FXML
    private Label label6N1;
    @FXML
    private Label label6N2;
    @FXML
    private Label label6N3;
    @FXML
    private Label label6N4;
    @FXML
    private Label label6T1;
    @FXML
    private Label label6T2;
    @FXML
    private Label label6T3;
    @FXML
    private Label label6T4;
    @FXML
    private Label label6T5;
    @FXML
    private Label label6T6;
    @FXML
    private Label label7M1;
    @FXML
    private Label label7M2;
    @FXML
    private Label label7M3;
    @FXML
    private Label label7M4;
    @FXML
    private Label label7M5;
    @FXML
    private Label label7M6;
    @FXML
    private Label label7N1;
    @FXML
    private Label label7N2;
    @FXML
    private Label label7N3;
    @FXML
    private Label label7N4;
    @FXML
    private Label label7T1;
    @FXML
    private Label label7T2;
    @FXML
    private Label label7T3;
    @FXML
    private Label label7T4;
    @FXML
    private Label label7T5;
    @FXML
    private Label label7T6;
    @FXML
    private ChoiceBox<String> choiceBoxBuscar;
    @FXML
    private Button botaoPesquisar;
    @FXML
    private TextField TextFieldBuscar;
    @FXML
    private Button botaoVoltarBuscar;

    private Stage interacao;

    /**
     * Classes utilizadas para se conectar ao banco de dados
     * @see model.database.Database
     * @see model.database.DatabasePostgreSQL#conectar
     */
    private final TurmasDAO turmaDAO = new TurmasDAO();
    private final Database database = new DatabasePostgreSQL();
    private final Connection connection = database.conectar();

    // Preenchendo os ChoiceBox da interface gráfica
    private List<Turma> listHorarios;
    private ObservableList<String> choiceBoxBuscarList = FXCollections.observableArrayList("Todos","1", "2", "3", "4", "5", "6");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        turmaDAO.setConnection(connection);
        choiceBoxBuscar.setItems(choiceBoxBuscarList);
        choiceBoxBuscar.setValue("Todos");
    }

    /**
     * Metodo para preencher a tabela de horários das turmas
     *@see #limparTelaHorario
     */
    public void handleBotaoPesquisar() {
        limparTelaHorario();
        if(TextFieldBuscar.getText() != null && choiceBoxBuscar.getValue() == "Todos"){
            listHorarios = turmaDAO.horariosDocente(TextFieldBuscar.getText());
            for (int i = 0; i < listHorarios.size(); i++) {
                if (listHorarios.get(i).getHorarios().length() == 9) {
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("2")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label2N1.setText(listHorarios.get(i).getCodTurma());
                                label2N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label2N3.setText(listHorarios.get(i).getCodTurma());
                                label2N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("2")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label2N1.setText(listHorarios.get(i).getCodTurma());
                                label2N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label2N3.setText(listHorarios.get(i).getCodTurma());
                                label2N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("3")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label3M1.setText(listHorarios.get(i).getCodTurma());
                                label3M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label3M3.setText(listHorarios.get(i).getCodTurma());
                                label3M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label3M5.setText(listHorarios.get(i).getCodTurma());
                                label3M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label3T1.setText(listHorarios.get(i).getCodTurma());
                                label3T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label3T3.setText(listHorarios.get(i).getCodTurma());
                                label3T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label3T5.setText(listHorarios.get(i).getCodTurma());
                                label3T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label3N1.setText(listHorarios.get(i).getCodTurma());
                                label3N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label3N3.setText(listHorarios.get(i).getCodTurma());
                                label3N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("3")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label3M1.setText(listHorarios.get(i).getCodTurma());
                                label3M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label3M3.setText(listHorarios.get(i).getCodTurma());
                                label3M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label3M5.setText(listHorarios.get(i).getCodTurma());
                                label3M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label3T1.setText(listHorarios.get(i).getCodTurma());
                                label3T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label3T3.setText(listHorarios.get(i).getCodTurma());
                                label3T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label3T5.setText(listHorarios.get(i).getCodTurma());
                                label3T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label3N1.setText(listHorarios.get(i).getCodTurma());
                                label3N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label3N3.setText(listHorarios.get(i).getCodTurma());
                                label3N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("4")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe4M1.setText(listHorarios.get(i).getCodTurma());
                                labe4M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe4M3.setText(listHorarios.get(i).getCodTurma());
                                labe4M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                labe4M5.setText(listHorarios.get(i).getCodTurma());
                                labe4M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe4T1.setText(listHorarios.get(i).getCodTurma());
                                labe4T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe4T3.setText(listHorarios.get(i).getCodTurma());
                                labe4T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                labe4T5.setText(listHorarios.get(i).getCodTurma());
                                labe4T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe4N1.setText(listHorarios.get(i).getCodTurma());
                                labe4N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe4N3.setText(listHorarios.get(i).getCodTurma());
                                labe4N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("4")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe4M1.setText(listHorarios.get(i).getCodTurma());
                                labe4M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe4M3.setText(listHorarios.get(i).getCodTurma());
                                labe4M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                labe4M5.setText(listHorarios.get(i).getCodTurma());
                                labe4M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe4T1.setText(listHorarios.get(i).getCodTurma());
                                labe4T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe4T3.setText(listHorarios.get(i).getCodTurma());
                                labe4T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                labe4T5.setText(listHorarios.get(i).getCodTurma());
                                labe4T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe4N1.setText(listHorarios.get(i).getCodTurma());
                                labe4N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe4N3.setText(listHorarios.get(i).getCodTurma());
                                labe4N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("5")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label5M1.setText(listHorarios.get(i).getCodTurma());
                                label5M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label5M3.setText(listHorarios.get(i).getCodTurma());
                                label5M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label5M5.setText(listHorarios.get(i).getCodTurma());
                                label5M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label5T1.setText(listHorarios.get(i).getCodTurma());
                                label5T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label5T3.setText(listHorarios.get(i).getCodTurma());
                                label5T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label5T5.setText(listHorarios.get(i).getCodTurma());
                                label5T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe5N1.setText(listHorarios.get(i).getCodTurma());
                                labe5N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe5N3.setText(listHorarios.get(i).getCodTurma());
                                labe5N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("5")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label5M1.setText(listHorarios.get(i).getCodTurma());
                                label5M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label5M3.setText(listHorarios.get(i).getCodTurma());
                                label5M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label5M5.setText(listHorarios.get(i).getCodTurma());
                                label5M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label5T1.setText(listHorarios.get(i).getCodTurma());
                                label5T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label5T3.setText(listHorarios.get(i).getCodTurma());
                                label5T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label5T5.setText(listHorarios.get(i).getCodTurma());
                                label5T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe5N1.setText(listHorarios.get(i).getCodTurma());
                                labe5N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe5N3.setText(listHorarios.get(i).getCodTurma());
                                labe5N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("6")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label6M1.setText(listHorarios.get(i).getCodTurma());
                                label6M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label6M3.setText(listHorarios.get(i).getCodTurma());
                                label6M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label6M5.setText(listHorarios.get(i).getCodTurma());
                                label6M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label6T1.setText(listHorarios.get(i).getCodTurma());
                                label6T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label6T3.setText(listHorarios.get(i).getCodTurma());
                                label6T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label6T5.setText(listHorarios.get(i).getCodTurma());
                                label6T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label6N1.setText(listHorarios.get(i).getCodTurma());
                                label6N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label6N3.setText(listHorarios.get(i).getCodTurma());
                                label6N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("6")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label6M1.setText(listHorarios.get(i).getCodTurma());
                                label6M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label6M3.setText(listHorarios.get(i).getCodTurma());
                                label6M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label6M5.setText(listHorarios.get(i).getCodTurma());
                                label6M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label6T1.setText(listHorarios.get(i).getCodTurma());
                                label6T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label6T3.setText(listHorarios.get(i).getCodTurma());
                                label6T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label6T5.setText(listHorarios.get(i).getCodTurma());
                                label6T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label6N1.setText(listHorarios.get(i).getCodTurma());
                                label6N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label6N3.setText(listHorarios.get(i).getCodTurma());
                                label6N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("7")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label7M1.setText(listHorarios.get(i).getCodTurma());
                                label7M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label7M3.setText(listHorarios.get(i).getCodTurma());
                                label7M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label7M5.setText(listHorarios.get(i).getCodTurma());
                                label7M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label7T1.setText(listHorarios.get(i).getCodTurma());
                                label7T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label7T3.setText(listHorarios.get(i).getCodTurma());
                                label7T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label7T5.setText(listHorarios.get(i).getCodTurma());
                                label7T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label7N1.setText(listHorarios.get(i).getCodTurma());
                                label7N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label7N3.setText(listHorarios.get(i).getCodTurma());
                                label7N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("7")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label7M1.setText(listHorarios.get(i).getCodTurma());
                                label7M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label7M3.setText(listHorarios.get(i).getCodTurma());
                                label7M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label7M5.setText(listHorarios.get(i).getCodTurma());
                                label7M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label7T1.setText(listHorarios.get(i).getCodTurma());
                                label7T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label7T3.setText(listHorarios.get(i).getCodTurma());
                                label7T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label7T5.setText(listHorarios.get(i).getCodTurma());
                                label7T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label7N1.setText(listHorarios.get(i).getCodTurma());
                                label7N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label7N3.setText(listHorarios.get(i).getCodTurma());
                                label7N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                } else if (listHorarios.get(i).getHorarios().length() == 5) {
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("2")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("3")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("4")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("5")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("3")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("4")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("5")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("4")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("5")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("5")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                } 
                            } 
                    }
                }
                else{
                    if(listHorarios.get(i).getHorarios().substring(0, 1).matches("2")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("3")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("4")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("5")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("6")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("7")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                }
            }
        }else if(TextFieldBuscar.getText().length() == 0 && choiceBoxBuscar.getValue() != "Todos"){
            listHorarios = turmaDAO.horariosSemestre(Integer.parseInt(choiceBoxBuscar.getValue()));
            for (int i = 0; i < listHorarios.size(); i++) {
                if (listHorarios.get(i).getHorarios().length() == 9) {
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("2")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label2N1.setText(listHorarios.get(i).getCodTurma());
                                label2N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label2N3.setText(listHorarios.get(i).getCodTurma());
                                label2N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("2")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label2N1.setText(listHorarios.get(i).getCodTurma());
                                label2N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label2N3.setText(listHorarios.get(i).getCodTurma());
                                label2N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("3")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label3M1.setText(listHorarios.get(i).getCodTurma());
                                label3M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label3M3.setText(listHorarios.get(i).getCodTurma());
                                label3M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label3M5.setText(listHorarios.get(i).getCodTurma());
                                label3M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label3T1.setText(listHorarios.get(i).getCodTurma());
                                label3T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label3T3.setText(listHorarios.get(i).getCodTurma());
                                label3T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label3T5.setText(listHorarios.get(i).getCodTurma());
                                label3T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label3N1.setText(listHorarios.get(i).getCodTurma());
                                label3N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label3N3.setText(listHorarios.get(i).getCodTurma());
                                label3N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("3")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label3M1.setText(listHorarios.get(i).getCodTurma());
                                label3M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label3M3.setText(listHorarios.get(i).getCodTurma());
                                label3M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label3M5.setText(listHorarios.get(i).getCodTurma());
                                label3M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label3T1.setText(listHorarios.get(i).getCodTurma());
                                label3T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label3T3.setText(listHorarios.get(i).getCodTurma());
                                label3T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label3T5.setText(listHorarios.get(i).getCodTurma());
                                label3T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label3N1.setText(listHorarios.get(i).getCodTurma());
                                label3N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label3N3.setText(listHorarios.get(i).getCodTurma());
                                label3N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("4")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe4M1.setText(listHorarios.get(i).getCodTurma());
                                labe4M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe4M3.setText(listHorarios.get(i).getCodTurma());
                                labe4M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                labe4M5.setText(listHorarios.get(i).getCodTurma());
                                labe4M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe4T1.setText(listHorarios.get(i).getCodTurma());
                                labe4T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe4T3.setText(listHorarios.get(i).getCodTurma());
                                labe4T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                labe4T5.setText(listHorarios.get(i).getCodTurma());
                                labe4T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe4N1.setText(listHorarios.get(i).getCodTurma());
                                labe4N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe4N3.setText(listHorarios.get(i).getCodTurma());
                                labe4N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("4")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe4M1.setText(listHorarios.get(i).getCodTurma());
                                labe4M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe4M3.setText(listHorarios.get(i).getCodTurma());
                                labe4M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                labe4M5.setText(listHorarios.get(i).getCodTurma());
                                labe4M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe4T1.setText(listHorarios.get(i).getCodTurma());
                                labe4T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe4T3.setText(listHorarios.get(i).getCodTurma());
                                labe4T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                labe4T5.setText(listHorarios.get(i).getCodTurma());
                                labe4T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe4N1.setText(listHorarios.get(i).getCodTurma());
                                labe4N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe4N3.setText(listHorarios.get(i).getCodTurma());
                                labe4N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("5")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label5M1.setText(listHorarios.get(i).getCodTurma());
                                label5M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label5M3.setText(listHorarios.get(i).getCodTurma());
                                label5M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label5M5.setText(listHorarios.get(i).getCodTurma());
                                label5M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label5T1.setText(listHorarios.get(i).getCodTurma());
                                label5T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label5T3.setText(listHorarios.get(i).getCodTurma());
                                label5T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label5T5.setText(listHorarios.get(i).getCodTurma());
                                label5T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                labe5N1.setText(listHorarios.get(i).getCodTurma());
                                labe5N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                labe5N3.setText(listHorarios.get(i).getCodTurma());
                                labe5N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("5")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label5M1.setText(listHorarios.get(i).getCodTurma());
                                label5M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label5M3.setText(listHorarios.get(i).getCodTurma());
                                label5M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label5M5.setText(listHorarios.get(i).getCodTurma());
                                label5M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label5T1.setText(listHorarios.get(i).getCodTurma());
                                label5T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label5T3.setText(listHorarios.get(i).getCodTurma());
                                label5T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label5T5.setText(listHorarios.get(i).getCodTurma());
                                label5T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                labe5N1.setText(listHorarios.get(i).getCodTurma());
                                labe5N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                labe5N3.setText(listHorarios.get(i).getCodTurma());
                                labe5N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("6")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label6M1.setText(listHorarios.get(i).getCodTurma());
                                label6M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label6M3.setText(listHorarios.get(i).getCodTurma());
                                label6M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label6M5.setText(listHorarios.get(i).getCodTurma());
                                label6M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label6T1.setText(listHorarios.get(i).getCodTurma());
                                label6T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label6T3.setText(listHorarios.get(i).getCodTurma());
                                label6T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label6T5.setText(listHorarios.get(i).getCodTurma());
                                label6T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label6N1.setText(listHorarios.get(i).getCodTurma());
                                label6N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label6N3.setText(listHorarios.get(i).getCodTurma());
                                label6N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("6")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label6M1.setText(listHorarios.get(i).getCodTurma());
                                label6M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label6M3.setText(listHorarios.get(i).getCodTurma());
                                label6M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label6M5.setText(listHorarios.get(i).getCodTurma());
                                label6M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label6T1.setText(listHorarios.get(i).getCodTurma());
                                label6T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label6T3.setText(listHorarios.get(i).getCodTurma());
                                label6T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label6T5.setText(listHorarios.get(i).getCodTurma());
                                label6T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label6N1.setText(listHorarios.get(i).getCodTurma());
                                label6N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label6N3.setText(listHorarios.get(i).getCodTurma());
                                label6N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("7")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label7M1.setText(listHorarios.get(i).getCodTurma());
                                label7M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label7M3.setText(listHorarios.get(i).getCodTurma());
                                label7M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label7M5.setText(listHorarios.get(i).getCodTurma());
                                label7M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label7T1.setText(listHorarios.get(i).getCodTurma());
                                label7T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label7T3.setText(listHorarios.get(i).getCodTurma());
                                label7T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("56")) {
                                label7T5.setText(listHorarios.get(i).getCodTurma());
                                label7T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 4).matches("12")) {
                                label7N1.setText(listHorarios.get(i).getCodTurma());
                                label7N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(2, 4).matches("34")) {
                                label7N3.setText(listHorarios.get(i).getCodTurma());
                                label7N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                    if (listHorarios.get(i).getHorarios().substring(5, 6).matches("7")) {
                        if (listHorarios.get(i).getHorarios().substring(6, 7).matches("M")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label7M1.setText(listHorarios.get(i).getCodTurma());
                                label7M2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label7M3.setText(listHorarios.get(i).getCodTurma());
                                label7M4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label7M5.setText(listHorarios.get(i).getCodTurma());
                                label7M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("T")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label7T1.setText(listHorarios.get(i).getCodTurma());
                                label7T2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label7T3.setText(listHorarios.get(i).getCodTurma());
                                label7T4.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("56")) {
                                label7T5.setText(listHorarios.get(i).getCodTurma());
                                label7T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        } else if (listHorarios.get(i).getHorarios().substring(6, 7).matches("N")) {
                            if (listHorarios.get(i).getHorarios().substring(7, 9).matches("12")) {
                                label7N1.setText(listHorarios.get(i).getCodTurma());
                                label7N2.setText(listHorarios.get(i).getCodTurma());
                            } else if (listHorarios.get(i).getHorarios().substring(7, 9).matches("34")) {
                                label7N3.setText(listHorarios.get(i).getCodTurma());
                                label7N4.setText(listHorarios.get(i).getCodTurma());
                            }
                        }
                    }
                } else if (listHorarios.get(i).getHorarios().length() == 5) {
                    if (listHorarios.get(i).getHorarios().substring(0, 1).matches("2")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("3")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("4")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("5")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("3")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("4")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("5")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("4")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("5")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("5")) {
                        if (listHorarios.get(i).getHorarios().substring(1, 2).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                        else if (listHorarios.get(i).getHorarios().substring(1, 2).matches("7")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                }
                            }
                        }
                    }else if (listHorarios.get(i).getHorarios().substring(0, 1).matches("6")) {
                            if (listHorarios.get(i).getHorarios().substring(2, 3).matches("M")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2M1.setText(listHorarios.get(i).getCodTurma());
                                    label2M2.setText(listHorarios.get(i).getCodTurma());
                                    label3M1.setText(listHorarios.get(i).getCodTurma());
                                    label3M2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2M3.setText(listHorarios.get(i).getCodTurma());
                                    label2M4.setText(listHorarios.get(i).getCodTurma());
                                    label3M3.setText(listHorarios.get(i).getCodTurma());
                                    label3M4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2M5.setText(listHorarios.get(i).getCodTurma());
                                    label2M6.setText(listHorarios.get(i).getCodTurma());
                                    label3M5.setText(listHorarios.get(i).getCodTurma());
                                    label3M6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("T")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2T1.setText(listHorarios.get(i).getCodTurma());
                                    label2T2.setText(listHorarios.get(i).getCodTurma());
                                    label3T1.setText(listHorarios.get(i).getCodTurma());
                                    label3T2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2T3.setText(listHorarios.get(i).getCodTurma());
                                    label2T4.setText(listHorarios.get(i).getCodTurma());
                                    label3T3.setText(listHorarios.get(i).getCodTurma());
                                    label3T4.setText(listHorarios.get(i).getCodTurma());
                                }else if(listHorarios.get(i).getHorarios().substring(3, 5).matches("56")){
                                    label2T5.setText(listHorarios.get(i).getCodTurma());
                                    label2T6.setText(listHorarios.get(i).getCodTurma());
                                    label3T5.setText(listHorarios.get(i).getCodTurma());
                                    label3T6.setText(listHorarios.get(i).getCodTurma());
                                }
                            }else if (listHorarios.get(i).getHorarios().substring(2, 3).matches("N")) {
                                if (listHorarios.get(i).getHorarios().substring(3, 5).matches("12")) {
                                    label2N1.setText(listHorarios.get(i).getCodTurma());
                                    label2N2.setText(listHorarios.get(i).getCodTurma());
                                    label3N1.setText(listHorarios.get(i).getCodTurma());
                                    label3N2.setText(listHorarios.get(i).getCodTurma());
                                } else if (listHorarios.get(i).getHorarios().substring(3, 5).matches("34")) {
                                    label2N3.setText(listHorarios.get(i).getCodTurma());
                                    label2N4.setText(listHorarios.get(i).getCodTurma());
                                    label3N3.setText(listHorarios.get(i).getCodTurma());
                                    label3N4.setText(listHorarios.get(i).getCodTurma());
                                } 
                            } 
                    }
                }
                else{
                    if(listHorarios.get(i).getHorarios().substring(0, 1).matches("2")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("3")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("4")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("5")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("6")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                    else if(listHorarios.get(i).getHorarios().substring(0, 1).matches("7")){
                        if(listHorarios.get(i).getHorarios().substring(1, 2).matches("M")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2M1.setText(listHorarios.get(i).getCodTurma());
                                label2M2.setText(listHorarios.get(i).getCodTurma());
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2M3.setText(listHorarios.get(i).getCodTurma());
                                label2M4.setText(listHorarios.get(i).getCodTurma());
                                label2M5.setText(listHorarios.get(i).getCodTurma());
                                label2M6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("T")){
                            if(listHorarios.get(i).getHorarios().substring(2, 6).matches("1234")){
                                label2T1.setText(listHorarios.get(i).getCodTurma());
                                label2T2.setText(listHorarios.get(i).getCodTurma());
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                            }else{
                                label2T3.setText(listHorarios.get(i).getCodTurma());
                                label2T4.setText(listHorarios.get(i).getCodTurma());
                                label2T5.setText(listHorarios.get(i).getCodTurma());
                                label2T6.setText(listHorarios.get(i).getCodTurma());
                            }
                        }if(listHorarios.get(i).getHorarios().substring(1, 2).matches("N")){
                            label2N1.setText(listHorarios.get(i).getCodTurma());
                            label2N2.setText(listHorarios.get(i).getCodTurma());
                            label2N3.setText(listHorarios.get(i).getCodTurma());
                            label2N4.setText(listHorarios.get(i).getCodTurma());
                        }
                    }
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Escolha buscar turmas pro professor ou semestre separadamente!");
            alert.show();
        }
    }

    @FXML
    public void handleBotaoVoltar(){
        interacao.close();
    }
    public void setInteracao(Stage interacao) {
        this.interacao = interacao;
    }

    /*Metodo para limpar os campos do horário para um nova consulta
     */
    public void limparTelaHorario() {
        // Limpando a tabela de horario da segunda
        label2M1.setText("");
        label2M2.setText("");
        label2M3.setText("");
        label2M4.setText("");
        label2M5.setText("");
        label2M6.setText("");
        label2T1.setText("");
        label2T2.setText("");
        label2T3.setText("");
        label2T4.setText("");
        label2T5.setText("");
        label2T6.setText("");
        label2N1.setText("");
        label2N2.setText("");
        label2N3.setText("");
        label2N4.setText("");
        // Limpando a tabela de horario da terça
        label3M1.setText("");
        label3M2.setText("");
        label3M3.setText("");
        label3M4.setText("");
        label3M5.setText("");
        label3M6.setText("");
        label3T1.setText("");
        label3T2.setText("");
        label3T3.setText("");
        label3T4.setText("");
        label3T5.setText("");
        label3T6.setText("");
        label3N1.setText("");
        label3N2.setText("");
        label3N3.setText("");
        label3N4.setText("");
        // Limpando a tabela de horario da quarta
        labe4M1.setText("");
        labe4M2.setText("");
        labe4M3.setText("");
        labe4M4.setText("");
        labe4M5.setText("");
        labe4M6.setText("");
        labe4T1.setText("");
        labe4T2.setText("");
        labe4T3.setText("");
        labe4T4.setText("");
        labe4T5.setText("");
        labe4T6.setText("");
        labe4N1.setText("");
        labe4N2.setText("");
        labe4N3.setText("");
        labe4N4.setText("");
        // Limpando a tabela de horario da quinta
        label5M1.setText("");
        label5M2.setText("");
        label5M3.setText("");
        label5M4.setText("");
        label5M5.setText("");
        label5M6.setText("");
        label5T1.setText("");
        label5T2.setText("");
        label5T3.setText("");
        label5T4.setText("");
        label5T5.setText("");
        label5T6.setText("");
        labe5N1.setText("");
        labe5N2.setText("");
        labe5N3.setText("");
        labe5N4.setText("");
        // Limpando a tabela de horario da sexta
        label6M1.setText("");
        label6M2.setText("");
        label6M3.setText("");
        label6M4.setText("");
        label6M5.setText("");
        label6M6.setText("");
        label6T1.setText("");
        label6T2.setText("");
        label6T3.setText("");
        label6T4.setText("");
        label6T5.setText("");
        label6T6.setText("");
        label6N1.setText("");
        label6N2.setText("");
        label6N3.setText("");
        label6N4.setText("");
        // Limpando a tabela de horario do sabado
        label7M1.setText("");
        label7M2.setText("");
        label7M3.setText("");
        label7M4.setText("");
        label7M5.setText("");
        label7M6.setText("");
        label7T1.setText("");
        label7T2.setText("");
        label7T3.setText("");
        label7T4.setText("");
        label7T5.setText("");
        label7T6.setText("");
        label7N1.setText("");
        label7N2.setText("");
        label7N3.setText("");
        label7N4.setText("");
    }
}
