package technobytes.com.eloquence.utils.eventbus;

import com.squareup.otto.Bus;

import org.androidannotations.annotations.EBean;

/**
 * Created by seisan on 5/5/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class EventsBus extends Bus {
}
