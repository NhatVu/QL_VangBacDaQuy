/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVCControllers;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JOptionPane;

import main.CheckInput;
import DTO.P_ChiDTO;
import MVCModels.PhieuChiModel;
import MVCViews.PhieuChiView;

/**
 *
 * @author Minh Nhat
 */
public class PhieuChiController implements Controller {

	PhieuChiModel model = new PhieuChiModel();
	PhieuChiView view = null;
	private Controller parent;

	public void start() {
		view = new PhieuChiView(this);
		view.getFrame().setVisible(true);
		setParentVisiableFalse();
	}

	public void btnLuuActionPerformed(ActionEvent e) {
		P_ChiDTO p_ChiDTO = new P_ChiDTO();
		p_ChiDTO.setMaP_Chi(Integer.parseInt(view.getTextMaPhieu().getText()));
		p_ChiDTO.setNgayChi(new Timestamp(view.getDateNgayChi().getDate()
				.getTime()));

		// if (!CheckInput.isCharacter(view.getTextNoiDung().getText())) {
		// JOptionPane.showMessageDialog(null,
		// "Vui lòng không nhập ký tự đặc biệt");
		// return;
		//
		// }
		p_ChiDTO.setNoiDung(view.getTextNoiDung().getText());

		if (!CheckInput.isDouble(view.getTextSoTienChi().getText())
				|| !CheckInput.isStringMax50(view.getTextSoTienChi().getText())
				|| !CheckInput.isStringMax300(view.getTextNoiDung().getText())) {
			JOptionPane.showMessageDialog(null,
					"Vui lòng kiểm tra lại thông tin");
			return;
		}
		p_ChiDTO.setSoTienChi(Double.parseDouble(view.getTextSoTienChi()
				.getText()));

		model.insert(p_ChiDTO);
		JOptionPane.showMessageDialog(null, "Lưu thành công");
		// xóa nọi dung, tạo lại phiếu mới
		view.getTextNoiDung().setText(null);
		view.getTextSoTienChi().setText(null);

		view.getFrame().dispatchEvent(
				new WindowEvent(view.getFrame(), WindowEvent.WINDOW_OPENED));

	}

	public void btnThoatActionEvent(ActionEvent e) {
		// view.getFrame().dispatchEvent(new WindowEvent(view.getFrame(),
		// WindowEvent.WINDOW_CLOSING));
		view.getFrame().setVisible(false);
		setParentVisiableTrue();
	}

	public void frameWindowOpened(WindowEvent e) {
		view.getTextMaPhieu().setText(String.valueOf(model.getNextID()));
		view.getDateNgayChi().setDate(new Date());
	}

	@Override
	public void setParent(Controller parent) {
		this.parent = parent;
		parent.addChild(this);
	}

	@Override
	public void setParentVisiableFalse() {
		this.parent.setParentVisiableFalse();
	}

	@Override
	public void setParentVisiableTrue() {
		this.parent.setParentVisiableTrue();
	}

	@Override
	public void addChild(Controller child) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	@Override
	public void dipose() {
		view.getFrame().dispatchEvent(
				new WindowEvent(view.getFrame(), WindowEvent.WINDOW_CLOSING));
	}
}
