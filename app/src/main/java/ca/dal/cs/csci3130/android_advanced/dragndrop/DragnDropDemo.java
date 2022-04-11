package ca.dal.cs.csci3130.android_advanced.dragndrop;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import ca.dal.cs.csci3130.android_advanced.R;

public class DragnDropDemo extends AppCompatActivity {

    ImageView img;
    String message;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragn_drop_demo);

        img = findViewById(R.id.myImage);
        img.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item = new ClipData.Item((CharSequence) view.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData dragData = new ClipData(view.getTag().toString(), mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);
                view.startDrag(dragData, myShadow, null, 0);
                return true;
            }
        });

        img.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                switch (dragEvent.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        layoutParams=(LinearLayout.LayoutParams) view.getLayoutParams();
                        Log.d("STARTED","Dragging started!");
                        break;
                    case DragEvent.ACTION_DRAG_ENTERED:
                        int x_cord = (int) dragEvent.getX();
                        int y_cord=(int)dragEvent.getY();
                        Log.d("ENTERED","Entered into dragging!");
                        break;
                    case DragEvent.ACTION_DRAG_EXITED:
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        layoutParams.leftMargin=x_cord;
                        layoutParams.topMargin=y_cord;
                        Log.d("EXITED","Dragging exited!");
                        break;
                    case DragEvent.ACTION_DRAG_LOCATION:
                        x_cord=(int)dragEvent.getX();
                        y_cord=(int)dragEvent.getY();
                        Log.d("LOCATION","Dragging location!");
                        break;

                    case DragEvent.ACTION_DRAG_ENDED:
                        //do something
                        Log.d("ENDED","Dragging ended!");
                        break;
                    case DragEvent.ACTION_DROP:
                        Log.d("DROP","Item dropped!");
                        //do something
                        break;

                        default:
                            break;
                }
                return false;
            }
        });

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);

                    img.startDrag(data, shadowBuilder, img, 0);
                    img.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });

    }
}