package ex.android.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
//  Fragment를 상속 받음
    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }


    //  onCreateView() 프래그먼트 레이아웃이 필요할 때 안드로이드가 호출하는 코드
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //  Fragment가 어떤 레이아웃을 사용하는지 안드로이드에 알려줌.
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        TextView title = (TextView) view.findViewById(R.id.textTitle);
        Workout workout = Workout.workouts[(int) workoutId];
        title.setText( workout.getName() );
        TextView description = (TextView) view.findViewById(R.id.textDescription);
        description.setText( workout.getDescription() );
    }

}
