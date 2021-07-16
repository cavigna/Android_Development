package id.haerulmuttaqin.jobfinder.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import id.haerulmuttaqin.jobfinder.base.BaseViewModel;
import id.haerulmuttaqin.jobfinder.data.api.ConnectionServer;

public class MainViewModel extends BaseViewModel {
    public MainViewModel(Context context, ConnectionServer connectionServer) {
        super(context, connectionServer);
    }

    public static class ModelFactory implements ViewModelProvider.Factory{
        private Context context;
        private ConnectionServer server;

        public ModelFactory(Context context, ConnectionServer server) {
            this.context = context;
            this.server = server;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new MainViewModel(context, server);
        }
    }



    interface Navigator{
        void showProgress();
        void hideProgress();

    }
}
