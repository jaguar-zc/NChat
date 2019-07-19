package org.flyants.common.utils;

import java.util.List;

public interface UploadCallbacks {
    void onProgressUpdate(int percentage);

    void onError();

    void onSuccessful(List<String> path);
}
