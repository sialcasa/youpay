package de.buildpath.youpay.favourite;

import de.buildpath.youpay.commands.Command;
import de.saxsys.mvvmfx.ViewModel;

public class FavouriteViewModel implements ViewModel {

    private Command accountListRequest;
    private Command favouriteDetailViewRequest;

    public Command getFavouriteDetailViewRequest() {
        return favouriteDetailViewRequest;
    }

    public void setFavouriteDetailViewRequest(Command favouriteDetailViewRequest) {
        this.favouriteDetailViewRequest = favouriteDetailViewRequest;
    }

    public Command getAccountListRequest() {
        return accountListRequest;
    }

    public void setAccountListRequest(Command accountListRequest) {
        this.accountListRequest = accountListRequest;
    }

}
