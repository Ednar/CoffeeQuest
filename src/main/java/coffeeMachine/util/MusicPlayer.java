package coffeeMachine.util;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import java.io.*;

/**
 * Musikspelare som kör hjältens titelmelodi i en bakgrundsprocess.
 *
 */
public class MusicPlayer {

    /**
     * Spelar förvald musik en bakgrundsprocess.
     */
    public static void playThemeSong() {
        ((Runnable) () -> {
            Sequencer sequencer = null;
            try {
                sequencer = MidiSystem.getSequencer();
                sequencer.open();
                InputStream is = new BufferedInputStream(new FileInputStream(new File("rain.mid")));
                sequencer.setSequence(is);
                sequencer.start();
            } catch (MidiUnavailableException | IOException | InvalidMidiDataException e) {
                // Ignored
            }

        }).run();

    }
}
