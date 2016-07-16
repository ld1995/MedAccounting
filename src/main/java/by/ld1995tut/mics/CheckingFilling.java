package by.ld1995tut.mics;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class CheckingFilling extends DocumentFilter
{
    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length,
                        String text, javax.swing.text.AttributeSet attr)

            throws BadLocationException
    {
        super.replace(fb, offset, length, text.replaceAll("[^А-ЯЁа-яё]",""), attr);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
    {
        fb.insertString(offset, string.replaceAll("[^А-ЯЁа-яё]",""), attr);
    }
}
