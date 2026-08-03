package yajco.example.sml;

import yajco.example.sml.model.StateMachine;
import yajco.example.sml.parser.StateMachineParser;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        try (InputStream in = Main.class.getResourceAsStream("/machine.sml")) {
            if (in == null) throw new RuntimeException("machine.sml not found");
            StateMachine machine = new StateMachineParser().parse(new InputStreamReader(in));
            System.out.println("OUTPUT:");
            System.out.println(machine);
        }
    }
}
