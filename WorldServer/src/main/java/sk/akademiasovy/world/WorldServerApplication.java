package sk.akademiasovy.world;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sk.akademiasovy.world.resources.HelloWorld;
import sk.akademiasovy.world.resources.World;

public class WorldServerApplication extends Application<WorldServerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WorldServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "WorldServer";
    }

    @Override
    public void initialize(final Bootstrap<WorldServerConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final WorldServerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(
                new HelloWorld()
        );
        environment.jersey().register(
                new World()
        );
    }

}
