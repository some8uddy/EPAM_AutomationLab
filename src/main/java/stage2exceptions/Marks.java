package stage2exceptions;

import stage2exceptions.exceptions.GradeOutOfBoundsException;

import java.util.List;

public class Marks {
    private List<Integer> marks;

    public Marks(List<Integer> marks) throws GradeOutOfBoundsException {
        for (Integer i : marks) {
            if ((i < 0) || (i > 10)) {
                throw new GradeOutOfBoundsException("Grade should be a number from 0 to 10, but " + i + " found.");
            }
        }
        this.marks = marks;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) throws GradeOutOfBoundsException {
        for (Integer i : marks) {
            if ((i < 0) || (i > 10)) {
                throw new GradeOutOfBoundsException("Grade should be a number from 0 to 10, but " + i + " found.");
            }
        }
        this.marks = marks;
    }

    public void addMark(int mark) throws GradeOutOfBoundsException {
        if ((mark < 0) || (mark > 10)) {
            throw new GradeOutOfBoundsException("Grade should be a number from 0 to 10, but " + mark + " found.");
        }
        this.marks.add(mark);
    }
}
