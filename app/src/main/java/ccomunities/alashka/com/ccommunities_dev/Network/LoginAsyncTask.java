package ccomunities.alashka.com.ccommunities_dev.Network;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ccomunities.alashka.com.ccommunities_dev.LoginActivity;
import ccomunities.alashka.com.ccommunities_dev.Model.User;
import ccomunities.alashka.com.ccommunities_dev.R;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginAsyncTask extends AsyncTask<User, Void, List<User>> {
    private LoginActivity loginActivity;

    public LoginAsyncTask(LoginActivity activity) {
        loginActivity = activity;
    }

    @Override
    protected List<User> doInBackground(User... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ccommunitiesservice-dev.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CCommunitiesService service = retrofit.create(CCommunitiesService.class);
        Call<List<User>> call = service.getUsers();

        try {
            Response<List<User>> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(List<User> users) {
        if (users == null) {
            Toast.makeText(loginActivity, "Username and Password invalid. Try again please.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(loginActivity, "LOGIN SUCCESSFULL!!", Toast.LENGTH_LONG).show();
            /*SharedPreferences sharedPreferences = loginActivity   .getSharedPreferences(loginActivity.getString(R.string.app_name), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("user_id", user.getUserId());
            editor.commit();

            Intent intent = new Intent(loginActivity, PostActivity.class);
            loginActivity.startActivity(intent);*/
        }
    }
}
