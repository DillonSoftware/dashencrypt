package com.castlabs.dash.dashfragmenter.representation;

import com.coremedia.iso.boxes.Container;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

public class DashTrackWriter {
    public static void write(RepresentationBuilder representationBuilder, String out) throws IOException {
        WritableByteChannel wbc = Channels.newChannel(new FileOutputStream(out));
        representationBuilder.getInitSegment().writeContainer(wbc);
        representationBuilder.getIndexSegment().writeContainer(wbc);

        for (Container fragment : representationBuilder) {
            fragment.writeContainer(wbc);
        }

    }
}