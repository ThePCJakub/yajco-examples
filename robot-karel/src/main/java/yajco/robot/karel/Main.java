package yajco.robot.karel;

import yajco.robot.karel.model.Program;
import yajco.robot.karel.parser.Parser;
import yajco.robot.karel.runtime.World;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        World world = new World();
        try (InputStream mapStream = Main.class.getResourceAsStream("/level1.map")) {
            if (mapStream == null) throw new RuntimeException("/level1.map not found");
            world.load(new InputStreamReader(mapStream));
        }

        Program program;
        try (InputStream programStream = Main.class.getResourceAsStream("/test.kar")) {
            if (programStream == null) throw new RuntimeException("/test.kar not found");

            program = new Parser().parse(new InputStreamReader(programStream));
        }
        program.execute(world);
        world.print();
    }
}
