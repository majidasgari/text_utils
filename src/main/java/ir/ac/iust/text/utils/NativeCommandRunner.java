package ir.ac.iust.text.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Majid on 30/05/2015.
 */
public class NativeCommandRunner {


    public static void runCommand(String... commands) throws IOException, InterruptedException {
        if (File.separator.equals("\\"))
            runCommandInWindows(commands);
        else runCommandInLinux(commands);
    }

    private static void runCommandInWindows(String... commands) throws IOException {
        commands[0] = FileHandler.getPath("windows", commands[0] + ".exe").toString();
        String[] commandsToCmd = new String[commands.length + 2];
        commandsToCmd[0] = "CMD";
        commandsToCmd[1] = "/C";
        System.arraycopy(commands, 0, commandsToCmd, 2, commands.length);
        ProcessBuilder probuilder = new ProcessBuilder(commandsToCmd);
        Process process = probuilder.start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runCommandInLinux(String... commands) throws IOException, InterruptedException {
        commands[0] = FileHandler.getPath("linux", commands[0]).toFile().getAbsolutePath();
        System.out.println(StringUtils.join(commands, " "));
        Process p = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", StringUtils.join(commands, " ")});
        int code = p.waitFor();
        System.out.println("code: " + code);
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuffer output = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        System.out.println(output);
    }
}
