package OOP5;

import javafx.scene.control.TextField;

/**
 * Textfield used only for entering a number value.
 *
 * @author Erik
 */
public class NumberTextField extends TextField
{
    /**
     * Replaces a range of characters with the given text, here to replace everything
     * which isn't a number with nothing.
     *
     * @author Erik
     * @param start - The starting index in the range, inclusive.
     *              This must be >=0 and < the end.
     * @param end - The ending index in the range, exclusive. This
     *            is one-past the last character to delete. This must
     *            be > the start, and <= the length of the text.
     * @param text - The text that is to replace the range.
     *             This must not be null.
     */
    @Override
    public void replaceText(int start, int end, String text)
    {
        if(text.matches("[0-9]") || text.equals("")){
            super.replaceText(start,end,text);
        }
    }

    /**
     * Replaces the selection with the given replacement String, to make
     * sure only numbers can be entered into the NumberTextField. If there is no selection,
     * then the replacement text is simply inserted at the current caret position.
     * If there was a selection, then the selection is cleared and the given replacement text inserted.
     *
     * @author Erik
     * @param text - String which is selected to be replaced.
     */
    @Override
    public void replaceSelection(String text)
    {
        if(text.matches("[0-9]") || text.equals("")){
            super.replaceSelection(text);
        }
    }
}
