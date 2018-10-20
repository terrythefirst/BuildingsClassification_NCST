package terry.com.buildingsclassification_ncst.Tensorflow;

import java.util.List;

public class TFConfig {
    public static List<Classifier.Recognition> results= null;
    public static final int INPUT_SIZE = 299;
    public static final int IMAGE_MEAN = 128;
    public static final float IMAGE_STD = 128;
    public static final String INPUT_NAME = "Mul";
    public static final String OUTPUT_NAME = "final_result";


    public static final String MODEL_FILE = "file:///android_asset/tf_graph/retrained_graph_stripped.pb";
    public static final String LABEL_FILE =
            "file:///android_asset/tf_graph/buildingLabels.txt";
}
