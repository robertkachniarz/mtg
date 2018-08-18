package pl.sdacademy.mtg;

import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.api.SetAPI;
import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdacademy.mtg.controller.MainViewController;

import java.io.IOException;
import java.util.List;

public class Main extends Application {
    private Stage stage;
    private VBox layout;

    public Main(){}

    public static void main(String[] args) {
       /* int multiverseId = 1;
        MtgCardJSON card = CardAPI.getCard(multiverseId);
       // List<MtgCardJSON> cards = CardAPI.getAllCards();
        //System.out.println(cards.toString());
        String setCode = "KLD";
        MtgSet set = SetAPI.getSet(setCode);
        List<MtgCardJSON> kld = set.getCards();
        System.out.println(card.getImageUrl());
       // System.out.println(kld.toString());*/

       launch();
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("MTGViewer");
        loadView();
    }

    public void loadView() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/MainView.fxml"));
            layout = (VBox) loader.load();

            MainViewController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(layout);
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException err){
            err.printStackTrace();
        }
    }
}
