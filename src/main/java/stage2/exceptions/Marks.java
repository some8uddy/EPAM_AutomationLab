package stage2.exceptions;

import stage2.exceptions.customexceptions.GradeOutOfBoundsException;

import java.util.List;

public class Marks {
    private List<Integer> marks;

    public Marks(List<Integer> marks) throws GradeOutOfBoundsException {
        for (Integer i : marks) {
            assureMarkIsCorrect(i);
        }
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) throws GradeOutOfBoundsException {
        for (Integer i : marks) {
            assureMarkIsCorrect(i);
        }
        this.marks = marks;
    }

    public void addMark(int mark) throws GradeOutOfBoundsException {
        assureMarkIsCorrect(mark);
        this.marks.add(mark);
    }

    private void assureMarkIsCorrect(Integer mark) throws GradeOutOfBoundsException {
        if ((mark < 0) || (mark > 10)) {
            throw new GradeOutOfBoundsException("Grade should be a number from 0 to 10, but " + mark + " found.");
        }
    }

    @Override
    public String toString() {
        return "" + marks;
    }
}
