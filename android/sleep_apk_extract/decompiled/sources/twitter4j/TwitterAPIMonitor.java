package twitter4j;

import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import twitter4j.management.APIStatistics;
import twitter4j.management.APIStatisticsOpenMBean;

/* JADX INFO: loaded from: classes5.dex */
public class TwitterAPIMonitor {
    private static final APIStatistics STATISTICS;
    private static final Logger logger = Logger.getLogger(TwitterAPIMonitor.class);
    private static final Pattern pattern = Pattern.compile("https?://[^/]+/[0-9.]*/([a-zA-Z_.]*).*");
    private static final TwitterAPIMonitor SINGLETON = new TwitterAPIMonitor();

    static {
        APIStatistics aPIStatistics = new APIStatistics(100);
        STATISTICS = aPIStatistics;
        try {
            ManagementFactory.getPlatformMBeanServer().registerMBean(new APIStatisticsOpenMBean(aPIStatistics), new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean"));
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } catch (NotCompliantMBeanException e2) {
            e2.printStackTrace();
            logger.error(e2.getMessage());
        } catch (InstanceAlreadyExistsException e3) {
            e3.printStackTrace();
            logger.error(e3.getMessage());
        } catch (MalformedObjectNameException e4) {
            e4.printStackTrace();
            logger.error(e4.getMessage());
        }
    }

    private TwitterAPIMonitor() {
    }

    public static TwitterAPIMonitor getInstance() {
        return SINGLETON;
    }

    public void methodCalled(String str, long j, boolean z) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches() || matcher.groupCount() <= 0) {
            return;
        }
        STATISTICS.methodCalled(matcher.group(1), j, z);
    }
}
