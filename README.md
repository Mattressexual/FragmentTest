# FragmentTest
Efficient switching to a new Fragment without destroying the old one.
Uses the .hide() and .show() methods of FragmentManager instead of .replace().
Hides current Fragment by tag using .getBackStackEntryAt() and .getBackStackEntryCount() to get the most recent tag from the BackStack
Selects Fragment by .findByFragmentTag(currentTag)
