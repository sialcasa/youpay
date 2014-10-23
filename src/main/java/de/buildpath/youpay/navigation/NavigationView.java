package de.buildpath.youpay.navigation;

import javafx.beans.property.StringProperty;
import javafx.scene.Parent;

public interface NavigationView {

    StringProperty titleProperty();

    Parent getView();

}
