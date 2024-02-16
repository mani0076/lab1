package data;

import androidx.lifecycle.MutableLiveData;
        import androidx.lifecycle.ViewModel;


public class MainViewModel extends ViewModel {
    public MutableLiveData<Boolean> isSelected= new MutableLiveData<>();

    public MainViewModel(){ isSelected.setValue(false);
    }
}
