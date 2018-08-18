package pl.sdacademy.mtg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.api.SetAPI;
import io.magicthegathering.javasdk.resource.MtgSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.sdacademy.mtg.Main;
import pl.sdacademy.mtg.model.MtgCard;
import pl.sdacademy.mtg.model.MtgCardJSON;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainViewController {
    private List<MtgSet> sets = SetAPI.getAllSets();
    private Main main;
    private ObservableList<MtgCard> cardsList = FXCollections.observableArrayList();

    @FXML
    private ComboBox checkSet;

    @FXML
    private TableView<MtgCard> cardsTable;

    @FXML
    private TableColumn<MtgCard, String> cardNameColumn;

    @FXML
    private ImageView cardImage;

    @FXML
    private Label cardNameLabel;

    @FXML
    private Label manaCostLabel;

    @FXML
    private Label cmcLabel;

    @FXML
    private Label typesLabel;

    @FXML
    private Label cardTextLabel;

    @FXML
    private Label expansionLabel;

    @FXML
    private Label rarityLabel;

    @FXML
    private Label artistLabel;

    @FXML
    private Label flavorTextLabel;

    public MainViewController(){}

    public List<MtgSet> getSets() {
        return sets;
    }

    public void setSets(List<MtgSet> sets) {
        this.sets = sets;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public ObservableList<MtgCard> cardConverterFromJSONToObservable(List<MtgCard> set){
        ObservableList<MtgCard> observableSets = FXCollections.observableArrayList();
        for (MtgCard c: set) {
            observableSets.add(c);
        }
        return observableSets;
    }

    @FXML
    public void initialize() throws IOException {
        loadFile();
        ObservableList<String> namesOfSets = FXCollections.observableArrayList();
        for (MtgSet mtgSet: sets){
            namesOfSets.add(mtgSet.getName());
        }
        checkSet.getItems().addAll(namesOfSets.sorted());
        //cardsList.add(new MtgCard("Fatal Push", "AKH", "Amonkhet", "http://www"));

    }

    public void loadFile() throws IOException {
        File fileSet = new File("allCards2.json");
        ObjectMapper mapper = new ObjectMapper();
        MtgCardJSON[] cards = mapper.readValue(fileSet, MtgCardJSON[].class);
        this.cardsList.clear();
        for (MtgCardJSON c:cards) {
            this.cardsList.add(new MtgCard(c.getName(), c.getMultiverseId(), c.getSetName()));
        }
    }

    @FXML
    public void loadListCardsFromSet() throws IOException {
        String nameSet = String.valueOf(checkSet.getSelectionModel().getSelectedItem());
        List<MtgCard> filterCards = this.cardsList.stream()
                .filter(c -> c.getSetName().equals(nameSet))
                .collect(Collectors.toList());
        fillTable(filterCards);
    }
    public void fillTable(List<MtgCard> cardlistFromSet){

        cardsTable.setItems(cardConverterFromJSONToObservable(cardlistFromSet));
        cardNameColumn.setCellValueFactory(cell -> cell.getValue().nameProperty());
        showCardDetails(null);
        cardsTable.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> showCardDetails(newValue)));
    }

    private void showCardDetails(MtgCard newValue) {
        if(newValue!=null){
            setOtherFieldsCard(newValue);
            String imageUrl = CardAPI.getCard(newValue.getMultiverseId()).getImageUrl();
            Image image = new Image(imageUrl, true);
            cardImage.setImage(image);
            cmcLabel.setText(String.valueOf(newValue.getCmc()));

            cardNameLabel.setText(newValue.getName());
            manaCostLabel.setText(newValue.getManaCost());
            typesLabel.setText(newValue.getType());
            cardTextLabel.setText(newValue.getText());
            rarityLabel.setText(newValue.getRarity());
            expansionLabel.setText(newValue.getSetName());
            artistLabel.setText(newValue.getArtist());
            flavorTextLabel.setText(newValue.getFlavor());

        }
    }

    private void setOtherFieldsCard(MtgCard card) {
        int multiverseID = card.getMultiverseId();

        card.setManaCost(CardAPI.getCard(multiverseID).getManaCost());
        card.setCmc(CardAPI.getCard(multiverseID).getCmc());
        card.setType(CardAPI.getCard(multiverseID).getType());
        card.setText(CardAPI.getCard(multiverseID).getText());
        card.setRarity(CardAPI.getCard(multiverseID).getRarity());
        card.setArtist(CardAPI.getCard(multiverseID).getArtist());
        card.setFlavor(CardAPI.getCard(multiverseID).getFlavor());

    }
}
