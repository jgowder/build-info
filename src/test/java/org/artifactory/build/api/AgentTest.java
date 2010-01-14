package org.artifactory.build.api;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;

/**
 * Tests the behavior of the agent class
 *
 * @author Noam Y. Tenne
 */
@Test
public class AgentTest {

    /**
     * Validates the agent values after initializing the default constructor
     */
    public void testEmptyConstructor() {
        Agent agent = new Agent();
        assertNull(agent.getName(), "Agent name should have not been initialized.");
        assertNull(agent.getVersion(), "Agent version should have not been initialized.");
        assertEquals(agent.toString(), "null/null", "Agent display representation should not be valid.");
    }

    /**
     * Validates the agent values after initializing the main constructor
     */
    public void testConstructor() {
        String name = "moo";
        String version = "1.5";

        Agent agent = new Agent(name, version);

        assertEquals(agent.getName(), name, "Unexpected agent name.");
        assertEquals(agent.getVersion(), version, "Unexpected agent version.");
        assertEquals(agent.toString(), name + "/" + version, "Unexpected agent display representation.");
    }

    /**
     * Validates the agent values after using the agent setters
     */
    public void testSetters() {
        String name = "pop";
        String version = "2.3";

        Agent agent = new Agent("moo", "1.5");

        agent.setName(name);
        agent.setVersion(version);
        assertEquals(agent.getName(), name, "Unexpected agent name.");
        assertEquals(agent.getVersion(), version, "Unexpected agent version.");
        assertEquals(agent.toString(), name + "/" + version, "Unexpected agent display representation.");
    }
}