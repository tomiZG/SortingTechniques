package ie.tomi;

import javax.servlet.annotation.WebServlet;
import java.util.*;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Slider;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.MultiSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Grid.SelectionMode;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout asks = new HorizontalLayout();

        // The heading and subtitle
        Label heading1 = new Label(
            "<h2>Sorting Techniques in Practice</h2> <p/>" + 
            "<h6>This app creates an array of numbers, prompts for array length, randomly fills the array with numbers from 1 to 100,</h6> <p/>" +
            "<h6>prompts for sorting technique to be applied upon unsorted array, sorts the array, prints number of passes.</h6>");
            heading1.setContentMode(com.vaadin.shared.ui.ContentMode.HTML);
        
        // The slider, thisManyToSort
        Slider thisManyToSort = new Slider(1, 100);
        thisManyToSort.setCaption("How large shall the array be?");
        //durationSlider.setOrientation(SliderOrientation.HORIZONTAL);
        thisManyToSort.setWidth("250px");
            
        // The ComboBox which sort technique shall be applied
        ComboBox<String> sortCombo = new ComboBox<>("Which sorting technique do you apply?");
        sortCombo.setItems("Bubble", "Insertion", "Selection", "Merge Sort");

        // The run button
        Button run = new Button("Run");


        // Put slider and ComboBox in horizontal line
        asks.addComponents(thisManyToSort, sortCombo);
        
        layout.addComponents(heading1, asks, run);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
