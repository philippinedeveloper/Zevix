package ph.bxtdev.Zevix;

import android.app.Activity;
import android.content.Context;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.MediaUtil;
import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

@DesignerComponent(
        version = 1,
        description = "Extension made by Bxtdev, Made using the powerful Warlock!, Designed to help Rapu to set images, you can set image on dynamically created components or the components not dynamically created",
        category = ComponentCategory.EXTENSION,
        nonVisible = true,
        iconName = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAQAAAD9CzEMAAAA9UlEQVRYw2NgGAWjgNpAmmEpwzOG/2TCZ0Dd0viNf0O24TD4Bp8VSyk2HgSX4rbgKVUseIrbgv9UgqMWjFowasGoBaMWEAvnMMynpQVnGTgYuBiu0MqCtwwKYPVaDF8ot2AOw1Q0kb8MXnAd8ZRacAYYFCwMe1DEGlH0zKfEAlhQCDLcgovtYGBC0YMtJoi04C+DJ1xGneE9WOwBgzCGLsyYINKCehQ5N4Y/DD8YTLHqiyfHgm1oQcHAkMeQjlPnfFItuM8gRFKTEzUmCFrwncGI5FYtckwQtCCZrIZz/EgoTWne+KV5853mHRCad6FGwSggBwAAd7ZU4N/jaCUAAAAASUVORK5CYII=")

@SimpleObject(external = true)
//Libraries
@UsesLibraries(libraries = "")
//Permissions
@UsesPermissions(permissionNames = "")

public class Zevix extends AndroidNonvisibleComponent {

    //Activity and Context
    private Context context;
    private Activity activity;
    private Form form;

    public Zevix(ComponentContainer container){
        super(container.$form());
        this.activity = container.$context();
        this.context = container.$context();
        this.form = container.$form();
    }

    @SimpleFunction(description = "Set an image to an ImageView component.")
    public void SetImage(AndroidViewComponent imageComponent, @Asset String image) {
      View view = imageComponent.getView();
      try {
        // Use MediaUtil to get a Drawable from the image file
        Drawable drawable = MediaUtil.getBitmapDrawable(form, image);
        
        // Convert Drawable to Bitmap
        Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();

        // Check if the view is an ImageView
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            // Set the Bitmap to the ImageView
            imageView.setImageBitmap(bitmap);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
