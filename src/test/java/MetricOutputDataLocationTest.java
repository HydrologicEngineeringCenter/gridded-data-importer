import hec.stats.Statistics;
import hec2.plugin.model.ModelAlternative;
import org.jdom.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MetricOutputDataLocationTest {

    @Test
    void toXML() {
        Statistics[] stats = new Statistics[]{Statistics.MAX,Statistics.MIN};
        MetricOutputDataLocation modl = new MetricOutputDataLocation(new ModelAlternative(),"Brennan","Flow", stats,true);
        Element parent = new Element("OutputDataLocations");
        modl.toXML(parent);
        assertEquals("MAX,MIN", parent.getChild("DataLocation").getAttributeValue("Metrics"));
    }
    @Test
    void fromXML() {
        Statistics[] stats = new Statistics[]{Statistics.MAX,Statistics.MIN};
        MetricOutputDataLocation modl = new MetricOutputDataLocation(new ModelAlternative(),"Brennan","Flow", stats, true);
        Element parent = new Element("OutputDataLocations");
        modl.toXML(parent);
        MetricOutputDataLocation backFromXML = new MetricOutputDataLocation();
        backFromXML.fromXML(parent.getChild("DataLocation"));
        assertArrayEquals(stats, backFromXML.getStats());
    }
}