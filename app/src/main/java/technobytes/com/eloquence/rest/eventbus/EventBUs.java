package technobytes.com.eloquence.rest.eventbus;

import com.squareup.otto.Bus;

import org.androidannotations.annotations.EBean;

/**
 * Created by seisan on 5/5/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class EventBus extends Bus {
}
