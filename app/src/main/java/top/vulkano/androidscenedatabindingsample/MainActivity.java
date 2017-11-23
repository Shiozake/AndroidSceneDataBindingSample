package top.vulkano.androidscenedatabindingsample;

import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import top.vulkano.androidscenedatabindingsample.databinding.SceneABinding;
import top.vulkano.androidscenedatabindingsample.databinding.SceneBBinding;
import top.vulkano.androidscenedatabindingsample.databinding.SceneCBinding;

public class MainActivity extends AppCompatActivity {

    private Scene sceneA;
    private Scene sceneB;
    private Scene sceneC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(this);
        ViewGroup sceneRoot = findViewById(R.id.scene_root);
        sceneA = createSceneA(inflater, sceneRoot);
        sceneB = createSceneB(inflater, sceneRoot);
        sceneC = createSceneC(inflater, sceneRoot);

        // 最初のシーンAへ
        TransitionManager.go(sceneA);
    }

    private Scene createSceneA(LayoutInflater inflater, ViewGroup sceneRoot) {
        SceneABinding binding = SceneABinding.inflate(inflater, sceneRoot, false);
        binding.setDescription("これはシーンAです。");
        binding.setButtonText("シーンBに行こうね");
        binding.setOnClickListener(view -> TransitionManager.go(sceneB));
        return new Scene(sceneRoot, binding.getRoot());
    }

    private Scene createSceneB(LayoutInflater inflater, ViewGroup sceneRoot) {
        SceneBBinding binding = SceneBBinding.inflate(inflater, sceneRoot, false);
        binding.setDescription("シーンBだよ");
        binding.setButtonText("シーンCになるよ");
        binding.setOnClickListener(view -> TransitionManager.go(sceneC));
        return new Scene(sceneRoot, binding.getRoot());
    }

    private Scene createSceneC(LayoutInflater inflater, ViewGroup sceneRoot) {
        SceneCBinding binding = SceneCBinding.inflate(inflater, sceneRoot, false);
        binding.setDescription("C");
        binding.setButtonText("Aに戻る");
        binding.setOnClickListener(view -> TransitionManager.go(sceneA));
        return new Scene(sceneRoot, binding.getRoot());
    }
}
