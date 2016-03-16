package local.watt.builditbigger.interfaces;

/**
 * Created by f4720431 on 2016/03/13.
 */
public interface OnTaskCompleted<E> {
    public void onComplete(String event);
    public void onError(Throwable error);
}
