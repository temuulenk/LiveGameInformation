package application.utility;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ChampionCircle {

    private int radius = 64;


    public ChampionCircle(AnchorPane anchorPane, String champion, int x, int y) {

        BufferedImage image = null;
        try {
            URL url = new URL("http://ddragon.leagueoflegends.com/cdn/8.11.1/img/champion/" + champion + ".png");
            image = ImageIO.read(url);
        }catch(IOException exception) {
            exception.printStackTrace();
        }

        Circle outline = new Circle(x, y, radius + 6);
        outline.setStroke(Paint.valueOf("#2c3e50"));
        outline.setStrokeWidth(3);
        outline.setFill(Paint.valueOf("transparent"));

        Circle inline = new Circle(x, y, radius);
        inline.setFill(new ImagePattern(SwingFXUtils.toFXImage(image.getSubimage(10, 10, 100, 100), null)));


        anchorPane.getChildren().addAll(outline, inline);

    }

}
