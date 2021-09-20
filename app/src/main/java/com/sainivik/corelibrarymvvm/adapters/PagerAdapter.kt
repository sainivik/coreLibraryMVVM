import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sainivik.corelibrarymvvm.ui.Fragments.AllMusicFragment
import com.sainivik.corelibrarymvvm.ui.Fragments.LocalMusicFragment

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return AllMusicFragment()
            }
            1 -> {
                return LocalMusicFragment()
            }
            else -> {
                return AllMusicFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "All Music"
            }
            1 -> {
                return "History"
            }
      
        }
        return super.getPageTitle(position)
    }

}
