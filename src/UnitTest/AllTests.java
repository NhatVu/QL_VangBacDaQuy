package UnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ NhapSanPhamModelTest.class, PhieuBanHangModelTest.class,
		PhieuChiModelTest.class, PhieuDichVuModelTest.class,
		PhieuGiaCongModelTest.class, PhieuMuaHangModelTest.class,
		PhieuNoModelTest.class, TonKhoModelTest.class })
public class AllTests {

}
