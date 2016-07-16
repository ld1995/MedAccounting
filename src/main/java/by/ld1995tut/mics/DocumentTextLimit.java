package by.ld1995tut.mics;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class DocumentTextLimit extends DocumentFilter {

        protected int MaxLength;

        public DocumentTextLimit(int MaxLength) {
            super();
            this.MaxLength = MaxLength;
        }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }


    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null && (string.length() + offset) <= MaxLength) {
            super.insertString(fb,offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null && (text.length() + offset) <= MaxLength) {
            super.replace(fb,offset, length, text, attrs);
        }
    }
}
