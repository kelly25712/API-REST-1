package intentoA.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import intentoA.demo.model.QRCode;
import intentoA.demo.repository.QRCodeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QRCodeService {
    @Autowired
	private QRCodeRepository repositor;

	public List<QRCode> getAll() {
		return repositor.findAll();
	}

	public List<QRCode> getAll(int page, int pageSize) {
		PageRequest pageReq = PageRequest.of(page, pageSize);
		Page<QRCode> qrcode = repositor.findAll(pageReq);
		return qrcode.getContent();
	}

	public QRCode save(QRCode qrCode) {
		return repositor.save(qrCode);
	}

	public QRCode getByIdQRCode(Integer idCode) {
		return repositor.findById(idCode).get();
	}

	public void delete(Integer idCode) {
		repositor.deleteById(idCode);
	}
}
