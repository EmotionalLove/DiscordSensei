package com.sasha.discordsensei.interpreter;

import com.sasha.discordsensei.Constants;
import com.sasha.discordsensei.teach.TeacherActivity;
import com.sasha.discordsensei.teach.TeacherActivityContainer;
import com.sasha.discordsensei.teach.impl.LessonActivity;

import static com.sasha.discordsensei.Constants.KEYWORD_FILETYPE;

/**
 * Created by Sasha at 1:07 PM on 12/21/2018
 */
public class ActivityInterpreter {

    private Mode mode = Mode.SETUP;
    private String[] fileLines;
    private TeacherActivityContainer container;
    private TeacherActivity activity = null;

    public void interpret() throws ActivityInterpreterException {
        Type type = null;
        for (int i = 0; i < fileLines.length; i++) {
            if (mode == Mode.ERR) throw new ErroredInterpreterException("Interpreter was switched to Errored mode!");
            String line = fileLines[i];
            if (i == 0 && !line.startsWith(KEYWORD_FILETYPE)) {
                throw new FileTypeNotDeclaredException("\"FILETYPE\" must be declared at the top of the document!");
            } else if (i == 0) {
                String fileType = line.replace(KEYWORD_FILETYPE, "").replace(" ", "").toUpperCase();
                try {
                    type = Type.valueOf(fileType);
                    mode = Mode.NORMAL;
                    continue;
                } catch (IllegalArgumentException ex) {
                    throw new FileTypeNotDeclaredException("Invalid FileType declared: " + fileType);
                }
            }
            switch (type) {
                case LESSON:
                    if (activity == null) {
                        activity = new LessonActivity();
                    }
                    continueInterpretingLesson(line);
                    break;
            }
        }
        container.addElement(activity);
    }

    private void continueInterpretingLesson(String line) {
        switch (mode) {
            case NORMAL:
                if (line.startsWith(Constants.KEYWORD_NAME)) {
                    activity.setActivityName(line.replace(Constants.KEYWORD_NAME, ""));
                    return;
                }
                if (line.startsWith(Constants.KEYWORD_OBJECTIVE)) {
                    ((LessonActivity) activity).objective = line.replace(Constants.KEYWORD_OBJECTIVE, "");
                    return;
                }
                if (line.startsWith(Constants.KEYWORD_REC_GOTO)) {
                    ((LessonActivity) activity).gotoNxt = line.replace(Constants.KEYWORD_REC_GOTO, "");
                    return;
                }
                if (line.trim().equals("LESSON START")) {
                    mode = Mode.INTRP_LESSONCONTENT;
                    return;
                }
                return;
            case INTRP_LESSONCONTENT:
                if (line.trim().equals("LESSON END")) {
                    mode = Mode.NORMAL;
                    return;
                }
                if (line.startsWith(">")) {
                    ((LessonActivity) activity).sections.add(line.replaceFirst(">", ""));
                }
        }
    }

}

class ActivityInterpreterException extends Error {
    public ActivityInterpreterException(String s) {
        super(s);
    }
}

class ErroredInterpreterException extends ActivityInterpreterException {

    public ErroredInterpreterException(String s) {
        super(s);
    }
}

class FileTypeNotDeclaredException extends ActivityInterpreterException {
    public FileTypeNotDeclaredException(String s) {
        super(s);
    }
}

enum Type {
    ASSESSMENT, QUIZ, LESSON
}

/**
 * Used to determine what the interpreter should expect next.
 */
enum Mode {
    SETUP, NORMAL, INTRP_LESSONCONTENT, INTRP_QUIZQUESTION, ERR
}