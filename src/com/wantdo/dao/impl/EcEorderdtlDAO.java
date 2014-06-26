package com.wantdo.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wantdo.dao.IEcEorderdtlDAO;
import com.wantdo.domain.EcEorderdtl;
import com.wantdo.domain.EcEorderdtlId;

/**
 * A data access object (DAO) providing persistence and search support for
 * EcEorderdtl entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wantdo.domain.EcEorderdtl
 * @author MyEclipse Persistence Tools
 */
public class EcEorderdtlDAO extends HibernateDaoSupport implements IEcEorderdtlDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EcEorderdtlDAO.class);
	// property constants
	public static final String ORDERNO = "orderno";
	public static final String CHILDFLG = "childflg";
	public static final String PARENTID = "parentid";
	public static final String ITEMNO = "itemno";
	public static final String RANKS = "ranks";
	public static final String MSUNIT = "msunit";
	public static final String QTY = "qty";
	public static final String SQTY = "sqty";
	public static final String PRICODE = "pricode";
	public static final String PRICEXS = "pricexs";
	public static final String PRICE = "price";
	public static final String ORDHWSUM = "ordhwsum";
	public static final String ORDERSUM = "ordersum";
	public static final String DISCRATE = "discrate";
	public static final String DISCSUM = "discsum";
	public static final String SENDSUM = "sendsum";
	public static final String SENDXS = "sendxs";
	public static final String SENDZK = "sendzk";
	public static final String INVSUM = "invsum";
	public static final String ACTSENDQTY = "actsendqty";
	public static final String SENDQTY = "sendqty";
	public static final String INVQTY = "invqty";
	public static final String SSENDQTY = "ssendqty";
	public static final String SINVQTY = "sinvqty";
	public static final String SACTSENDQTY = "sactsendqty";
	public static final String CURTYPE = "curtype";
	public static final String EXCHGRATE = "exchgrate";
	public static final String FPRICE = "fprice";
	public static final String FORDHWSUM = "fordhwsum";
	public static final String FORDERSUM = "fordersum";
	public static final String FDISCSUM = "fdiscsum";
	public static final String FSENDSUM = "fsendsum";
	public static final String FSENDXS = "fsendxs";
	public static final String FSENDZK = "fsendzk";
	public static final String FINVSUM = "finvsum";
	public static final String FMSUNIT = "fmsunit";
	public static final String UNITCHGN = "unitchgn";
	public static final String CHGBASE = "chgbase";
	public static final String FQTY = "fqty";
	public static final String FSENDQTY = "fsendqty";
	public static final String FINVQTY = "finvqty";
	public static final String FACTSENDQTY = "factsendqty";
	public static final String REMARKS = "remarks";
	public static final String OUTPRIFLG = "outpriflg";
	public static final String VIPFLG = "vipflg";
	public static final String SENDFLG = "sendflg";
	public static final String MINVFLG = "minvflg";
	public static final String RECFLG = "recflg";
	public static final String MAXPRICE = "maxprice";
	public static final String MINPRICE = "minprice";
	public static final String FMAXPRICE = "fmaxprice";
	public static final String FMINPRICE = "fminprice";
	public static final String BATCHNO = "batchno";
	public static final String RELLINE = "relline";
	public static final String VERSIONNO = "versionno";
	public static final String VERSIONMONEY = "versionmoney";
	public static final String TYPENO = "typeno";
	public static final String TYPEMONEY = "typemoney";
	public static final String TAXRATE = "taxrate";
	public static final String FNOTAXPRICE = "fnotaxprice";
	public static final String NOTAXPRICE = "notaxprice";
	public static final String ISPATTERN = "ispattern";
	public static final String FFEESUM = "ffeesum";
	public static final String FEESUM = "feesum";
	public static final String ATTRVALID = "attrvalid";
	public static final String UM_CONV_A = "umConvA";
	public static final String UM_CONV_AM = "umConvAm";
	public static final String CON_BILNID = "conBilnid";
	public static final String CON_CODE = "conCode";
	public static final String SKUID = "skuid";
	public static final String CQTY = "cqty";
	public static final String ORDERJF = "orderjf";
	public static final String ISINTERGAL = "isintergal";
	public static final String RETURNJF = "returnjf";
	public static final String ID_1 = "id_1";
	public static final String DISCOUNT = "discount";
	public static final String ISPRESENT = "ispresent";
	public static final String INVENTORYTYPE = "inventorytype";
	public static final String RELID = "relid";
	public static final String SHIPNO = "shipno";
	public static final String DEFWHLOC = "defwhloc";
	public static final String SOURCEORDER = "sourceorder";
	public static final String SOURCELINEID = "sourcelineid";
	public static final String BARCODE = "barcode";
	public static final String SCANPDAFLG = "scanpdaflg";
	public static final String SNAPSHOTURL = "snapshoturl";
	public static final String DEFWHOUSE = "defwhouse";
	public static final String RETURNFLAG = "returnflag";
	public static final String STOCKLOCKFLAG = "stocklockflag";
	public static final String DEFSHELF = "defshelf";
	public static final String SUPPLIERNO = "supplierno";
	public static final String PURCHASEFLAG = "purchaseflag";
	public static final String PURCHASEORDERID = "purchaseorderid";

	protected void initDao() {
		// do nothing
	}

	
	/* (·Ç Javadoc) 
	* <p>Title: save</p> 
	* <p>Description: </p> 
	* @param transientInstance 
	* @see com.wantdo.dao.impl.IEcEorderdtlDAO#save(com.wantdo.domain.EcEorderdtl) 
	*/ 
	@Override
	public void save(EcEorderdtl transientInstance) {
		log.debug("saving EcEorderdtl instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EcEorderdtl persistentInstance) {
		log.debug("deleting EcEorderdtl instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EcEorderdtl findById(com.wantdo.domain.EcEorderdtlId id) {
		log.debug("getting EcEorderdtl instance with id: " + id);
		try {
			EcEorderdtl instance = (EcEorderdtl) getHibernateTemplate().get(
					"com.wantdo.domain.EcEorderdtl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(EcEorderdtl instance) {
		log.debug("finding EcEorderdtl instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding EcEorderdtl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EcEorderdtl as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByOrderno(Object orderno) {
		return findByProperty(ORDERNO, orderno);
	}

	public List findByChildflg(Object childflg) {
		return findByProperty(CHILDFLG, childflg);
	}

	public List findByParentid(Object parentid) {
		return findByProperty(PARENTID, parentid);
	}

	public List findByItemno(Object itemno) {
		return findByProperty(ITEMNO, itemno);
	}

	public List findByRanks(Object ranks) {
		return findByProperty(RANKS, ranks);
	}

	public List findByMsunit(Object msunit) {
		return findByProperty(MSUNIT, msunit);
	}

	public List findByQty(Object qty) {
		return findByProperty(QTY, qty);
	}

	public List findBySqty(Object sqty) {
		return findByProperty(SQTY, sqty);
	}

	public List findByPricode(Object pricode) {
		return findByProperty(PRICODE, pricode);
	}

	public List findByPricexs(Object pricexs) {
		return findByProperty(PRICEXS, pricexs);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findByOrdhwsum(Object ordhwsum) {
		return findByProperty(ORDHWSUM, ordhwsum);
	}

	public List findByOrdersum(Object ordersum) {
		return findByProperty(ORDERSUM, ordersum);
	}

	public List findByDiscrate(Object discrate) {
		return findByProperty(DISCRATE, discrate);
	}

	public List findByDiscsum(Object discsum) {
		return findByProperty(DISCSUM, discsum);
	}

	public List findBySendsum(Object sendsum) {
		return findByProperty(SENDSUM, sendsum);
	}

	public List findBySendxs(Object sendxs) {
		return findByProperty(SENDXS, sendxs);
	}

	public List findBySendzk(Object sendzk) {
		return findByProperty(SENDZK, sendzk);
	}

	public List findByInvsum(Object invsum) {
		return findByProperty(INVSUM, invsum);
	}

	public List findByActsendqty(Object actsendqty) {
		return findByProperty(ACTSENDQTY, actsendqty);
	}

	public List findBySendqty(Object sendqty) {
		return findByProperty(SENDQTY, sendqty);
	}

	public List findByInvqty(Object invqty) {
		return findByProperty(INVQTY, invqty);
	}

	public List findBySsendqty(Object ssendqty) {
		return findByProperty(SSENDQTY, ssendqty);
	}

	public List findBySinvqty(Object sinvqty) {
		return findByProperty(SINVQTY, sinvqty);
	}

	public List findBySactsendqty(Object sactsendqty) {
		return findByProperty(SACTSENDQTY, sactsendqty);
	}

	public List findByCurtype(Object curtype) {
		return findByProperty(CURTYPE, curtype);
	}

	public List findByExchgrate(Object exchgrate) {
		return findByProperty(EXCHGRATE, exchgrate);
	}

	public List findByFprice(Object fprice) {
		return findByProperty(FPRICE, fprice);
	}

	public List findByFordhwsum(Object fordhwsum) {
		return findByProperty(FORDHWSUM, fordhwsum);
	}

	public List findByFordersum(Object fordersum) {
		return findByProperty(FORDERSUM, fordersum);
	}

	public List findByFdiscsum(Object fdiscsum) {
		return findByProperty(FDISCSUM, fdiscsum);
	}

	public List findByFsendsum(Object fsendsum) {
		return findByProperty(FSENDSUM, fsendsum);
	}

	public List findByFsendxs(Object fsendxs) {
		return findByProperty(FSENDXS, fsendxs);
	}

	public List findByFsendzk(Object fsendzk) {
		return findByProperty(FSENDZK, fsendzk);
	}

	public List findByFinvsum(Object finvsum) {
		return findByProperty(FINVSUM, finvsum);
	}

	public List findByFmsunit(Object fmsunit) {
		return findByProperty(FMSUNIT, fmsunit);
	}

	public List findByUnitchgn(Object unitchgn) {
		return findByProperty(UNITCHGN, unitchgn);
	}

	public List findByChgbase(Object chgbase) {
		return findByProperty(CHGBASE, chgbase);
	}

	public List findByFqty(Object fqty) {
		return findByProperty(FQTY, fqty);
	}

	public List findByFsendqty(Object fsendqty) {
		return findByProperty(FSENDQTY, fsendqty);
	}

	public List findByFinvqty(Object finvqty) {
		return findByProperty(FINVQTY, finvqty);
	}

	public List findByFactsendqty(Object factsendqty) {
		return findByProperty(FACTSENDQTY, factsendqty);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findByOutpriflg(Object outpriflg) {
		return findByProperty(OUTPRIFLG, outpriflg);
	}

	public List findByVipflg(Object vipflg) {
		return findByProperty(VIPFLG, vipflg);
	}

	public List findBySendflg(Object sendflg) {
		return findByProperty(SENDFLG, sendflg);
	}

	public List findByMinvflg(Object minvflg) {
		return findByProperty(MINVFLG, minvflg);
	}

	public List findByRecflg(Object recflg) {
		return findByProperty(RECFLG, recflg);
	}

	public List findByMaxprice(Object maxprice) {
		return findByProperty(MAXPRICE, maxprice);
	}

	public List findByMinprice(Object minprice) {
		return findByProperty(MINPRICE, minprice);
	}

	public List findByFmaxprice(Object fmaxprice) {
		return findByProperty(FMAXPRICE, fmaxprice);
	}

	public List findByFminprice(Object fminprice) {
		return findByProperty(FMINPRICE, fminprice);
	}

	public List findByBatchno(Object batchno) {
		return findByProperty(BATCHNO, batchno);
	}

	public List findByRelline(Object relline) {
		return findByProperty(RELLINE, relline);
	}

	public List findByVersionno(Object versionno) {
		return findByProperty(VERSIONNO, versionno);
	}

	public List findByVersionmoney(Object versionmoney) {
		return findByProperty(VERSIONMONEY, versionmoney);
	}

	public List findByTypeno(Object typeno) {
		return findByProperty(TYPENO, typeno);
	}

	public List findByTypemoney(Object typemoney) {
		return findByProperty(TYPEMONEY, typemoney);
	}

	public List findByTaxrate(Object taxrate) {
		return findByProperty(TAXRATE, taxrate);
	}

	public List findByFnotaxprice(Object fnotaxprice) {
		return findByProperty(FNOTAXPRICE, fnotaxprice);
	}

	public List findByNotaxprice(Object notaxprice) {
		return findByProperty(NOTAXPRICE, notaxprice);
	}

	public List findByIspattern(Object ispattern) {
		return findByProperty(ISPATTERN, ispattern);
	}

	public List findByFfeesum(Object ffeesum) {
		return findByProperty(FFEESUM, ffeesum);
	}

	public List findByFeesum(Object feesum) {
		return findByProperty(FEESUM, feesum);
	}

	public List findByAttrvalid(Object attrvalid) {
		return findByProperty(ATTRVALID, attrvalid);
	}

	public List findByUmConvA(Object umConvA) {
		return findByProperty(UM_CONV_A, umConvA);
	}

	public List findByUmConvAm(Object umConvAm) {
		return findByProperty(UM_CONV_AM, umConvAm);
	}

	public List findByConBilnid(Object conBilnid) {
		return findByProperty(CON_BILNID, conBilnid);
	}

	public List findByConCode(Object conCode) {
		return findByProperty(CON_CODE, conCode);
	}

	
	/* (·Ç Javadoc) 
	* <p>Title: findBySkuid</p> 
	* <p>Description: </p> 
	* @param skuid
	* @return 
	* @see com.wantdo.dao.impl.IEcEorderdtlDAO#findBySkuid(java.lang.Object) 
	*/ 
	@Override
	public List findBySkuid(Object skuid) {
		return findByProperty(SKUID, skuid);
	}

	public List findByCqty(Object cqty) {
		return findByProperty(CQTY, cqty);
	}

	public List findByOrderjf(Object orderjf) {
		return findByProperty(ORDERJF, orderjf);
	}

	public List findByIsintergal(Object isintergal) {
		return findByProperty(ISINTERGAL, isintergal);
	}

	public List findByReturnjf(Object returnjf) {
		return findByProperty(RETURNJF, returnjf);
	}

	public List findById_1(Object id_1) {
		return findByProperty(ID_1, id_1);
	}

	public List findByDiscount(Object discount) {
		return findByProperty(DISCOUNT, discount);
	}

	public List findByIspresent(Object ispresent) {
		return findByProperty(ISPRESENT, ispresent);
	}

	public List findByInventorytype(Object inventorytype) {
		return findByProperty(INVENTORYTYPE, inventorytype);
	}

	public List findByRelid(Object relid) {
		return findByProperty(RELID, relid);
	}

	public List findByShipno(Object shipno) {
		return findByProperty(SHIPNO, shipno);
	}

	public List findByDefwhloc(Object defwhloc) {
		return findByProperty(DEFWHLOC, defwhloc);
	}

	public List findBySourceorder(Object sourceorder) {
		return findByProperty(SOURCEORDER, sourceorder);
	}

	public List findBySourcelineid(Object sourcelineid) {
		return findByProperty(SOURCELINEID, sourcelineid);
	}

	public List findByBarcode(Object barcode) {
		return findByProperty(BARCODE, barcode);
	}

	public List findByScanpdaflg(Object scanpdaflg) {
		return findByProperty(SCANPDAFLG, scanpdaflg);
	}

	public List findBySnapshoturl(Object snapshoturl) {
		return findByProperty(SNAPSHOTURL, snapshoturl);
	}

	public List findByDefwhouse(Object defwhouse) {
		return findByProperty(DEFWHOUSE, defwhouse);
	}

	public List findByReturnflag(Object returnflag) {
		return findByProperty(RETURNFLAG, returnflag);
	}

	public List findByStocklockflag(Object stocklockflag) {
		return findByProperty(STOCKLOCKFLAG, stocklockflag);
	}

	public List findByDefshelf(Object defshelf) {
		return findByProperty(DEFSHELF, defshelf);
	}

	public List findBySupplierno(Object supplierno) {
		return findByProperty(SUPPLIERNO, supplierno);
	}

	public List findByPurchaseflag(Object purchaseflag) {
		return findByProperty(PURCHASEFLAG, purchaseflag);
	}

	public List findByPurchaseorderid(Object purchaseorderid) {
		return findByProperty(PURCHASEORDERID, purchaseorderid);
	}

	public List findAll() {
		log.debug("finding all EcEorderdtl instances");
		try {
			String queryString = "from EcEorderdtl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EcEorderdtl merge(EcEorderdtl detachedInstance) {
		log.debug("merging EcEorderdtl instance");
		try {
			EcEorderdtl result = (EcEorderdtl) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EcEorderdtl instance) {
		log.debug("attaching dirty EcEorderdtl instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EcEorderdtl instance) {
		log.debug("attaching clean EcEorderdtl instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IEcEorderdtlDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (IEcEorderdtlDAO) ctx.getBean("EcEorderdtlDAO");
	}
}