package onboarding.bankaccount;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

	@DisplayName("돈 단위에 따른 개수 반환 테스트")
	@Test
	void 돈_단위_별_개수_반환() {
		BankAccount account = new BankAccount(50_237);
		assertThat(
			account.getBillsOf(BankUnit.OH_MAN_WON)
		).isEqualTo(1);
		assertThat(
			account.getBillsOf(BankUnit.MAN_WON)
		).isEqualTo(5);
	}

	@DisplayName("단위별 전체 돈 개수 반환 테스트")
	@Test
	void 단위별_전체_돈_개수_반환() {
		BankAccount account = new BankAccount(50_237);
		List<Integer> bills = account.getBills();
		assertThat(bills).isEqualTo(List.of(1, 0, 0, 0, 0, 2, 3, 7));

		account = new BankAccount(15_000);
		bills = account.getBills();
		assertThat(bills).isEqualTo(List.of(0, 1, 1, 0, 0, 0, 0, 0));
	}
}
