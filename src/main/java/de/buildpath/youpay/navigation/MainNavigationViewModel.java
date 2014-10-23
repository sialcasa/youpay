package de.buildpath.youpay.navigation;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.buildpath.youpay.commands.Command;
import de.saxsys.mvvmfx.ViewModel;

public class MainNavigationViewModel implements ViewModel {

    private final StringProperty title = new SimpleStringProperty();
    private final BooleanProperty backNavigationPossible = new SimpleBooleanProperty();
    private Command backRequest;

    protected final StringProperty titleProperty() {
        return this.title;
    }

    protected final String getTitle() {
        return this.titleProperty().get();
    }

    protected final void setTitle(final String title) {
        this.titleProperty().set(title);
    }

    protected final BooleanProperty backNavigationPossibleProperty() {
        return this.backNavigationPossible;
    }

    protected final boolean isBackNavigationPossible() {
        return this.backNavigationPossibleProperty().get();
    }

    protected final void setBackNavigationPossible(final boolean backNavigationPossible) {
        this.backNavigationPossibleProperty().set(backNavigationPossible);
    }

    public Command getBackRequest() {
        return backRequest;
    }

    public void setBackRequest(Command backRequest) {
        this.backRequest = backRequest;
    }
}
