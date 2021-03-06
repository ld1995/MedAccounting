package by.ld1995tut.mics;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberFilling extends DocumentFilter
{
    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
                        String text, javax.swing.text.AttributeSet attr)

            throws BadLocationException
    {
        super.replace(fb, offset, length, text.replaceAll("[^0-9.]",""), attr);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
    {
        fb.insertString(offset, string.replaceAll("[^0-9.]",""), attr);
    }
}
