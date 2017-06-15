package nattysoft.com.carmarket;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import nattysoft.com.carmarket.screens.FragmentBuy;
import nattysoft.com.carmarket.screens.FragmentSell;

/**
 * Created by 13nat on 6/14/2017.
 */

public class MainFragment extends Fragment implements View.OnClickListener{
    private Button btn_buy_car;
    private Button btn_sell_car;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        btn_buy_car = (Button) view.findViewById(R.id.button_buy_car);
        btn_sell_car = (Button) view.findViewById(R.id.button_sell_car);
        btn_buy_car.setOnClickListener(this);
        btn_sell_car.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_buy_car:
                Fragment fragment1 = new FragmentBuy();
                moveToFragment(fragment1);
                break;
            case R.id.button_sell_car:
                Fragment fragment2 = new FragmentSell();
                moveToFragment(fragment2);
                break;
        }
    }

    private void moveToFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }
}
